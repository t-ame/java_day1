package com.java.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightTemplate {

	public int id;
	public String airline;
	public String from;
	public String to;
	public LocalDateTime departureTime;
	public LocalDateTime arrivalTime;
	public int seats;
	public float price;

	public FlightTemplate() {
		super();
	}

	public FlightTemplate(String airline, String from, String to, LocalDateTime departureTime,
			LocalDateTime arrivalTime, int seats, float price) {
		super();
		this.airline = airline;
		this.from = from;
		this.to = to;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seats = seats;
		this.price = price;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
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

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
