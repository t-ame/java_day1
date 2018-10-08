package com.java.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.components.ScheduledFlight;
import com.java.exception.GeneralException;
import com.java.services.FlightService;

/**
 * Servlet implementation class CustomerSearchServlet
 */
@WebServlet("/flightsearch")
public class CustomerSearchServlet extends HttpServlet {

	FlightService service;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String departure = (String) request.getAttribute("departure");
		String arrival = (String) request.getAttribute("destination");
		LocalDate date = LocalDate.parse((String) request.getAttribute("departure_date"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		if (!date.isBefore(LocalDate.now())) {
			request.setAttribute("errorMsg", "Departure date must be a future date!");
		}
		List<ScheduledFlight> flightList = null;
		
		try {
			flightList = service.getAllFlightsBetween(departure, arrival, date);
		} catch (GeneralException e) {
			request.setAttribute("exceptionMsg", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("/views/ErrorPage.jsp").forward(request, response);
		}
		
		if (flightList != null) {
			HttpSession session = request.getSession();
			if (session != null)
				session.setAttribute("flights", flightList);
			request.setAttribute("flights", flightList);
		} else {
			request.setAttribute("errorMsg", "No flights found!!!");
		}
		request.getRequestDispatcher("/views/CustomerFlightSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
