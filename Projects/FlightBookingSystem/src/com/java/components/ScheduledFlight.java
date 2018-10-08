package com.java.components;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduledFlight {

	public int id;
	public float cost;
	public LocalDateTime departureDate;
	public LocalDateTime arrivalDate;
	public String departureDateFormat;
	public String arrivalDateFormat;
	public String departure;
	public String destination;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	public boolean hasRoom() {

		return true;
	}

	public void addReservation() {

	}

	public void cancelReservation() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setDepartureDate(LocalDateTime date) {
		departureDateFormat = date.format(formatter);
		this.departureDate = date;
	}

	public void setArrivalDate(LocalDateTime date) {
		arrivalDateFormat = date.format(formatter);
		this.arrivalDate = date;
	}

	public String getFormattedDepartureDate() {
		return departureDateFormat;
	}

	public String getFormattedArrivalDate() {
		return arrivalDateFormat;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String from) {
		this.departure = from;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String to) {
		this.destination = to;
	}

}
