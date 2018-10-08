package com.java.services;

import java.time.LocalDate;
import java.util.List;

import com.java.components.BookedFlight;
import com.java.components.FlightTemplate;
import com.java.components.ScheduledFlight;
import com.java.exception.GeneralException;

public class FlightService {

	public ScheduledFlight getFlightById(int id) throws GeneralException {

		return null;
	}

	public FlightTemplate getSchedFlightById(int id) throws GeneralException {

		return null;
	}

	public List<ScheduledFlight> getAllFlightsBetween(String departure, String arrival, LocalDate date)
			throws GeneralException {

		return null;
	}

	public void addBooking(BookedFlight flight) throws GeneralException {

	}

	public void addFlight(FlightTemplate flight) throws GeneralException {

	}

	public void editFlight(FlightTemplate flight) throws GeneralException {

	}

	public void deleteFlight(int flightId) throws GeneralException {

	}

	// used by customer to view booking
	public BookedFlight getBooking(int id) throws GeneralException {

		return null;
	}

	// to be used by Admin
	public List<FlightTemplate> getAllFlights() throws GeneralException {

		return null;
	}

	// to be used by Admin
	public List<BookedFlight> getAllBookings() throws GeneralException {

		return null;
	}

}
