package com.java.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.components.Account;
import com.java.components.User;
import com.java.exception.GeneralException;
import com.java.services.AdminService;
import com.java.services.CustomerService;

/**
 * Servlet implementation class CustomerRegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService customerservice;
	private AdminService adminservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		To convert java.util.Date to java.sql.Date, just use its constructor.
//		preparedStatement.setDate(0, new java.sql.Date(date.getTime()));

		String firstName = (String) request.getAttribute("first_name");
		String lastName = (String) request.getAttribute("last_name");
		String username = (String) request.getAttribute("userName");
		String password = (String) request.getAttribute("password");
		boolean isAdmin = (boolean) request.getAttribute("isAdmin");

		Account account = new Account();
		String address = (String) request.getAttribute("street_address") + ", ";
		if (!((String) request.getAttribute("address_line_2")).isEmpty())
			address += (String) request.getAttribute("address_line_2") + ", ";
		if (!((String) request.getAttribute("address_line_3")).isEmpty())
			address += (String) request.getAttribute("address_line_3") + ", ";
		address += (String) request.getAttribute("city") + ", " + (String) request.getAttribute("state") + " "
				+ (String) request.getAttribute("zip_code");

		account.setDateOfBirth(LocalDate.parse((String) request.getAttribute("date_of_birth"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setPassword(password);
		account.setUserName(username);
		account.setAddress(address);
		if (((String) request.getAttribute("gender")).equalsIgnoreCase("female")) {
			account.setGender(Account.Gender.FEMALE);
		} else {
			account.setGender(Account.Gender.MALE);
		}

		User user = new User(isAdmin, account);

		try {
			if (isAdmin) {
				adminservice.addUser(user);
				request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
			} else {
				customerservice.addUser(user);
				request.getRequestDispatcher("CustomerLogin.jsp").forward(request, response);
			}
		} catch (GeneralException e) {
			request.setAttribute("exceptionMsg", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
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
