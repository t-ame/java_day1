package com.java.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookedFlight {

	private int id;
	private String airline;
	private String passengerName;
	private String from;
	private String to;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;

	void addScheduledFlight() {

	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passerngerName) {
		this.passengerName = passerngerName;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String parseDate(int arrival) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

		if (arrival == 0) {
			return departureTime.format(formatter);
		} else {
			return arrivalTime.format(formatter);
		}
	}

}
