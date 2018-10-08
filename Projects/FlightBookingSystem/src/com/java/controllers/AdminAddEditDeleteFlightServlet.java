package com.java.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.components.FlightTemplate;
import com.java.components.ScheduledFlight;
import com.java.exception.GeneralException;
import com.java.services.FlightService;

/**
 * Servlet implementation class AdminAddFlight
 */
@WebServlet(value = { "/addflight", "/changeflight", "/editflight/*", "/update", "/deleteflight/*" })
public class AdminAddEditDeleteFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final FlightService flight_service;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAddEditDeleteFlightServlet() {
		super();
		flight_service = new FlightService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getRequestURI().contains("addflight")) {
			String airline = (String) request.getAttribute("airline");
			String source = (String) request.getAttribute("source");
			String destination = (String) request.getAttribute("destination");
			Integer seats = Integer.parseInt((String) request.getAttribute("seats"));
			Float price = Float.parseFloat((String) request.getAttribute("price"));
			LocalDateTime departureDate = LocalDateTime.parse((String) request.getAttribute("depart_time"), formatter);
			LocalDateTime arrivalDate = LocalDateTime.parse((String) request.getAttribute("arrive_time"), formatter);
			FlightTemplate flight = new FlightTemplate(airline, source, destination, departureDate, arrivalDate, seats,
					price);

			try {
				flight_service.addFlight(flight);
			} catch (GeneralException e) {
				request.setAttribute("exceptionMsg", "Something went wrong: " + e.getMessage());
				request.getRequestDispatcher("/views/ErrorPage.jsp").forward(request, response);
			}
			request.setAttribute("successMsg", "You have successfully updated the flights");
			request.getRequestDispatcher("/views/SuccessPage.jsp").forward(request, response);

		} else if (request.getRequestURI().contains("changeflight")) {
			List<FlightTemplate> flights = null;
			HttpSession session = request.getSession();

			try {
				flights = flight_service.getAllFlights();
			} catch (GeneralException e) {
				request.setAttribute("exceptionMsg", "Something went wrong: " + e.getMessage());
				request.getRequestDispatcher("/views/ErrorPage.jsp").forward(request, response);
			}
			if (session != null)
				session.setAttribute("flights", flights);
			if (flights == null) {
				request.setAttribute("errorMsg", "There are no scheduled flights.");
			}
			request.getRequestDispatcher("/views/AdminDisplayAllFlights.jsp").forward(request, response);

		} else if (request.getRequestURI().contains("editflight")) {

			String[] pathInfo = request.getRequestURI().split("/");
			System.out.println(pathInfo[pathInfo.length - 1]);
			Integer flightId = -1;
			FlightTemplate flight;

			try {
				flightId = Integer.parseInt(pathInfo[pathInfo.length - 1]);
				flight = flight_service.getSchedFlightById(flightId);
				request.setAttribute("flight", flight);
				request.getRequestDispatcher("/views/AdminEditFlight.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				response.sendError(404);
				return;
			} catch (GeneralException e) {
				request.setAttribute("exceptionMsg", "Something went wrong: " + e.getMessage());
				request.getRequestDispatcher("/views/ErrorPage.jsp").forward(request, response);
			}
		} else if (request.getRequestURI().contains("update")) {
			request.getRequestDispatcher("/addflight").forward(request, response);
		} else if (request.getRequestURI().contains("deleteflight")) {
			String[] pathInfo = request.getRequestURI().split("/");
			System.out.println(pathInfo[pathInfo.length - 1]);
			Integer flightId = -1;

			try {
				flightId = Integer.parseInt(pathInfo[pathInfo.length - 1]);
				flight_service.deleteFlight(flightId);
			} catch (NumberFormatException e) {
				response.sendError(404);
				return;
			} catch (GeneralException e) {
				request.setAttribute("exceptionMsg", "Something went wrong: " + e.getMessage());
				request.getRequestDispatcher("/views/ErrorPage.jsp").forward(request, response);
			}
			request.setAttribute("successMsg", "You have successfully Deleted the flight");
			request.getRequestDispatcher("/views/SuccessPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
