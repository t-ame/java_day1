package com.java.components;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String address;
	private LocalDate dateOfBirth;
	private String dob;

	public enum Gender {
		FEMALE, MALE;
	}

	private Gender gender;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	private void setDob() {
		dob = dateOfBirth.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
	}

	public String getDob() {
		setDob();
		return dob;
	}

}
