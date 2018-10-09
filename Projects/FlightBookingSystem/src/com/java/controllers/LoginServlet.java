package com.java.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.components.User;
import com.java.exception.GeneralException;
import com.java.services.AdminService;
import com.java.services.CustomerService;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService customerservice;
	private AdminService adminservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String username = (String) request.getAttribute("userName");
		String password = (String) request.getAttribute("password");
		boolean isAdmin = (boolean) request.getAttribute("isAdmin");

		User user = null;

		try {
			if (isAdmin) {
				user = adminservice.getUser(username);
			} else {
				user = customerservice.getUser(username);
			}
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(0);
			session.setAttribute("userdetails", user); // change other servlets using username then remove "username" and "isAdmin"
			session.setAttribute("username", username);
			session.setAttribute("isAdmin", isAdmin);
		} catch (GeneralException e) {
			request.setAttribute("exceptionMsg", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		}

		if (user != null) {
			if (isAdmin) {
				if (user.getAccount().getPassword().equals(password)) {
					request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
				} else {
					request.setAttribute("errorMsg", "Invalid username or password!");
					request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
				}
			} else {
				if (user.getAccount().getPassword().equals(password)) {
					request.getRequestDispatcher("CustomerHome.jsp").forward(request, response);
				} else {
					request.setAttribute("errorMsg", "Invalid username or password!");
					request.getRequestDispatcher("CustomerLogin.jsp").forward(request, response);
				}
			}
		}
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
