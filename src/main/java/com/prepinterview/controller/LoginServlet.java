package com.prepinterview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.User;
import com.prepinterview.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String topicIdString = req.getParameter("topicId");

		System.out.println(topicIdString);

		Session session = HibernateUtil.getSessionFactory().openSession();
		UserService userService = new UserService(session);

		User user = userService.loginUser(email, password);// Authenticate User

		if (user != null) {
			req.setAttribute("user", user);

			if (user.getRole().equals("ADMIN")) {

				resp.sendRedirect("AdminDashboard.jsp");

			} else {
				if (topicIdString != null) {
					resp.sendRedirect("TestPage.jsp");
				} else {
					resp.sendRedirect("UserDashboard.jsp");
				}

			}

		} else {
			resp.getWriter().write("Invalid username or password!");
		}

	}

}
