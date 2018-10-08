package com.java.components;

public class User {

	private String firstName;
	private String lastName;
	private String password;
	private boolean isAdmin;
	Account account;

	public User(String firstName, String lastName, String password, boolean isAdmin, Account account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.account = account;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
