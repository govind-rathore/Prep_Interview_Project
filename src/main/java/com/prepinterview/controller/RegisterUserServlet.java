package com.prepinterview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.User;
import com.prepinterview.service.UserService;

@WebServlet("/register-user")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ADMIN_KEY = "admin123";// Predefined Admin key

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String adminKey = req.getParameter("adminKey");

		if (role.equals("ADMIN") && !ADMIN_KEY.equals(adminKey)) {
			req.setAttribute("error", "Invalid authorization key for admin registration!");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
			return;
		}

		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);

		Session session = HibernateUtil.getSessionFactory().openSession();
		UserService userService = new UserService(session);
		userService.registerUser(user);
		resp.getWriter().write("Registered successfully!");

		session.close();

	}

}