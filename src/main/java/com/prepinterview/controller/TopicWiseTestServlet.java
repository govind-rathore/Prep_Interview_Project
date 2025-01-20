package com.prepinterview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.AptitudeTopic;
import com.prepinterview.entity.TestQuestion;
import com.prepinterview.service.FetchTopicsService;

@WebServlet("/topic-wise-test")
public class TopicWiseTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int topicId = Integer.parseInt(req.getParameter("topicId"));
		int userId = Integer.parseInt(req.getParameter("userId"));

		Session session = HibernateUtil.getSessionFactory().openSession();
		FetchTopicsService topicsService = new FetchTopicsService(session);
		AptitudeTopic topic = topicsService.getTopicById(topicId);

		List<TestQuestion> qlist = topic.getTestQuestions();

		if (qlist == null) {
			resp.getWriter().print("Sorry no data is fetched");
		} else {
			req.setAttribute("qlist", qlist);
			req.getRequestDispatcher("TestPage.jsp").forward(req, resp);

		}

		session.close();

	}

}
