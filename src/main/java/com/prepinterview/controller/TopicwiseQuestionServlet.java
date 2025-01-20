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
import com.prepinterview.entity.AptitudeQuestion;
import com.prepinterview.entity.AptitudeTopic;
import com.prepinterview.service.FetchTopicsService;

@WebServlet("/topicwise-question")
public class TopicwiseQuestionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int topicId = Integer.parseInt(req.getParameter("topicId"));

		Session session = HibernateUtil.getSessionFactory().openSession();
		FetchTopicsService topicsService = new FetchTopicsService(session);
		AptitudeTopic topic = topicsService.getTopicById(topicId);

		List<AptitudeQuestion> qlist = topic.getAptitudeQuestions();

		if (qlist == null) {
			resp.getWriter().print("Sorry no data is fetched");
		} else {
			req.setAttribute("qlist", qlist);
			req.getRequestDispatcher("TopicWiseQuestion.jsp").forward(req, resp);

		}

		session.close();
	}

}
