package com.java.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.components.BookedFlight;
import com.java.components.ScheduledFlight;
import com.java.components.User;
import com.java.exception.GeneralException;
import com.java.services.CustomerService;
import com.java.services.FlightService;

/**
 * Servlet implementation class CustomerBookingServlet
 */
@WebServlet(value= {"/booking/*","/flightbook"})
public class CustomerBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final FlightService flight_service;
	final CustomerService cust_service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerBookingServlet() {
        super();
        flight_service = new FlightService();
        cust_service = new CustomerService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getRequestURI().contains("booking")) {
			String[] pathInfo = request.getRequestURI().split("/");
			
			System.out.println(pathInfo[pathInfo.length-1]); //should give the ID of the flight selected for booing...
			Integer flightId = -1;
			try {
				flightId = Integer.parseInt(pathInfo[pathInfo.length-1]);
			} catch (NumberFormatException e) {
				response.sendError(404);
				return;
			}
			ScheduledFlight flight;
			try {
				flight = flight_service.getFlightById(flightId);
				if(flight.hasRoom()) {
					HttpSession session = request.getSession();
					if(session != null)
						session.setAttribute("flight", flight);
					request.getRequestDispatcher("/views/CustomerFlightBooking.jsp").forward(request, response);
				} else {
					request.setAttribute("errorMsg", "Selected flight is full.");
					request.getRequestDispatcher("/views/CustomerFlightSearch.jsp").forward(request, response);
				}
			} catch (GeneralException e) {
				request.setAttribute("exceptionMsg","Something went wrong: "+e.getMessage());
				request.getRequestDispatcher("/views/ErrorPage.jsp").forward(request, response);
			}
		} else if (request.getRequestURI().contains("flightbook")) {
			HttpSession session = request.getSession();
			if(session != null) {
				try {
					User user = cust_service.getUser((String)session.getAttribute("username"));
					ScheduledFlight flight = (ScheduledFlight)session.getAttribute("flight");
					BookedFlight flightTemp =  new BookedFlight();
					
					flightTemp.setPassengerName((String)request.getAttribute("full_name"));
					
					flightTemp.setArrivalTime(flight.getArrivalDate());
					flightTemp.setDepartureTime(flight.getDepartureDate());
					flightTemp.setFrom(flight.getDeparture());
					flightTemp.setTo(flight.getDestination());
					flight_service.addBooking(flightTemp);

					request.setAttribute("successMsg","You have successfully booked your flight");
					request.getRequestDispatcher("/views/SuccessPage.jsp").forward(request, response);
					
				} catch (GeneralException e) {
					request.setAttribute("exceptionMsg","Something went wrong: "+e.getMessage());
					request.getRequestDispatcher("/views/ErrorPage.jsp").forward(request, response);
				}
				
			} else {
				request.getRequestDispatcher("/views/CustomerLogin.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
