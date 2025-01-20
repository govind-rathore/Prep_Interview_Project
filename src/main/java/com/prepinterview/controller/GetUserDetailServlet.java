package com.prepinterview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.User;
import com.prepinterview.service.UserService;

@WebServlet("/getUserDetail")
public class GetUserDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userId"));

		Session session = HibernateUtil.getSessionFactory().openSession();
		UserService userService = new UserService(session);
		User user = userService.getUserById(userId);

		req.setAttribute("userId", user.getUserId());
		req.setAttribute("userName", user.getUserName());
		req.setAttribute("email", user.getEmail());
		req.setAttribute("resultList", user.getResults());
		RequestDispatcher dispatcher = req.getRequestDispatcher("UserDashboard.jsp");
		dispatcher.forward(req, resp);

		session.close();
	}

}
