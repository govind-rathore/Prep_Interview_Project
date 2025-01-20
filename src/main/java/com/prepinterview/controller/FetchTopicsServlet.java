package com.prepinterview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.AptitudeTopic;
import com.prepinterview.service.FetchTopicsService;

@WebServlet("/all-topics")
public class FetchTopicsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String targetPage = req.getParameter("targetPage");

		// Default to AptitudeTopics.jsp if no targetPage is provided
		if (targetPage == null || targetPage.isEmpty()) {
			targetPage = "AptitudeTopics.jsp";
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		FetchTopicsService topicsService = new FetchTopicsService(session);
		List<AptitudeTopic> topics = topicsService.getTopics();

		req.setAttribute("topics", topics);
		RequestDispatcher rd = req.getRequestDispatcher(targetPage);
		rd.forward(req, resp);

		session.close();

	}

}
