package com.java.repositories;

import org.junit.Test;

import com.java.exception.GeneralException;
import com.java.services.FlightService;

public class Testing {

	FlightService service = new FlightService();
	
	@Test
	public void test() {

		try {
			System.out.println(service.getAllFlights());
		} catch (GeneralException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
