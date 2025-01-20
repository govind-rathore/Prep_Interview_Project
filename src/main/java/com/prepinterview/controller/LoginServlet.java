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
		String topicIdString = req.getParameter("topicId"); // Fetch topicId if available
		String topicName = req.getParameter("topicName");

		System.out.println("Topic ID: " + topicIdString);

		Session session = HibernateUtil.getSessionFactory().openSession();
		UserService userService = new UserService(session);

		// Authenticate the user
		User user = userService.loginUser(email, password);

		if (user != null) {
			req.setAttribute("user", user);

			// Redirect based on user role and presence of topicId
			if (user.getRole().equals("ADMIN")) {
				resp.sendRedirect("AdminDashboard.jsp");
			} else {
				if (topicIdString != null && !topicIdString.trim().isEmpty()) {
					resp.sendRedirect("TestInformationPage.jsp?topicId=" + topicIdString + "&userId=" + user.getUserId()
							+ "&topicName=" + topicName);
				} else {
					resp.sendRedirect("getUserDetail?userId=" + user.getUserId());
				}

			}
		} else {
			resp.getWriter().write("Invalid username or password!");
		}
	}
}
