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
import com.prepinterview.entity.TestQuestion;
import com.prepinterview.service.FetchTopicsService;
import com.prepinterview.service.TestQuestionService;

@WebServlet("/add-test-question")
public class AddTestQuestionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int topicId = Integer.parseInt(req.getParameter("topicId"));
		String topicName = req.getParameter("topicName");

		String question = req.getParameter("question");
		String optionA = req.getParameter("optionA");
		String optionB = req.getParameter("optionB");
		String optionC = req.getParameter("optionC");
		String optionD = req.getParameter("optionD");

		String correctOptionStr = req.getParameter("correctOption");
		char correctOption = correctOptionStr.charAt(0);

		int marks = Integer.parseInt(req.getParameter("marks"));

		String solution = req.getParameter("solution");

		TestQuestion testQuestion = new TestQuestion();
		testQuestion.setQuestion(question);
		testQuestion.setOptionA(optionA);
		testQuestion.setOptionB(optionB);
		testQuestion.setOptionC(optionC);
		testQuestion.setOptionD(optionD);
		testQuestion.setCorrectOption(correctOption);
		testQuestion.setSolution(solution);
		testQuestion.setMarks(marks);

		// Fetching AptitudeTopic Object to insert in aptitudeQuestions
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		FetchTopicsService topicsService = new FetchTopicsService(session1);
		AptitudeTopic topic = topicsService.getTopicById(topicId);

		session1.close();

		// Adding AptitudeTopic Object to aptitudeQuestions
		testQuestion.setTopic(topic);

		Session session2 = HibernateUtil.getSessionFactory().openSession();
		TestQuestionService questionService = new TestQuestionService(session2);
		questionService.addQuestion(testQuestion);

		resp.sendRedirect("AddTestQuestion.jsp?topicId=" + topicId + "&topicName=" + topicName);

		session2.close();
	}

}
