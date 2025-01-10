package com.prepinterview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.AptitudeQuestion;
import com.prepinterview.entity.AptitudeTopic;
import com.prepinterview.service.AptitudeQuestionService;
import com.prepinterview.service.FetchTopicsService;

@WebServlet("/add-question")
public class AddQuestionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int topicId = Integer.parseInt(req.getParameter("topicId"));
		String question = req.getParameter("question");
		String optionA = req.getParameter("optionA");
		String optionB = req.getParameter("optionB");
		String optionC = req.getParameter("optionC");
		String optionD = req.getParameter("optionD");

		String correctOptionStr = req.getParameter("correctOption");
		char correctOption = correctOptionStr.charAt(0);

		String solution = req.getParameter("solution");

		AptitudeQuestion aptitudeQuestions = new AptitudeQuestion();
		aptitudeQuestions.setQuestion(question);
		aptitudeQuestions.setOptionA(optionA);
		aptitudeQuestions.setOptionB(optionB);
		aptitudeQuestions.setOptionC(optionC);
		aptitudeQuestions.setOptionD(optionD);
		aptitudeQuestions.setCorrectOption(correctOption);
		aptitudeQuestions.setSolution(solution);

		// Fetching AptitudeTopic Object to insert in aptitudeQuestions
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		FetchTopicsService topicsService = new FetchTopicsService(session1);
		AptitudeTopic topic = topicsService.getTopicById(topicId);

		session1.close();

		// Adding AptitudeTopic Object to aptitudeQuestions
		aptitudeQuestions.setTopic(topic);

		Session session2 = HibernateUtil.getSessionFactory().openSession();
		AptitudeQuestionService questionService = new AptitudeQuestionService(session2);
		questionService.addQuestion(aptitudeQuestions);

		session2.close();

	}

}
