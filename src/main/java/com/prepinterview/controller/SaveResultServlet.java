package com.prepinterview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.AptitudeTopic;
import com.prepinterview.entity.SaveResult;
import com.prepinterview.entity.User;
import com.prepinterview.service.AptitudeTopicService;
import com.prepinterview.service.FetchTopicsService;
import com.prepinterview.service.SaveResultService;
import com.prepinterview.service.UserService;

@WebServlet("/save-result")
public class SaveResultServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get form data

		int topicId = Integer.parseInt(req.getParameter("topicId"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		int totalMarks = Integer.parseInt(req.getParameter("totalMarks"));
		int obtainedMarks = Integer.parseInt(req.getParameter("obtainedMarks"));

		SaveResult result = new SaveResult();
		result.setTotalMarks(totalMarks);
		result.setObtainedMarks(obtainedMarks);

		Session session1 = HibernateUtil.getSessionFactory().openSession();
		UserService userService = new UserService(session1);
		User user = userService.getUserById(userId);

		session1.close();

		Session session2 = HibernateUtil.getSessionFactory().openSession();
		FetchTopicsService topicsService = new FetchTopicsService(session2);
		AptitudeTopic topic = topicsService.getTopicById(topicId);

		session2.close();

		// Adding to result
		result.setTopic(topic);
		result.setUser(user);

		Session session3 = HibernateUtil.getSessionFactory().openSession();
		SaveResultService resultService = new SaveResultService(session3);
		resultService.saveResult(result);

		session3.close();

	}
}
