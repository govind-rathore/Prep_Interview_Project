package com.prepinterview.controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EvaluateTestServlet")
public class EvaluateTestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int totalQuestions = 0;
		int correctAnswers = 0;

		// Collect all submitted answers
		Enumeration<String> parameterNames = request.getParameterNames();

		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();

			// Check if the parameter is an answer
			if (paramName.startsWith("answer-")) {
				totalQuestions++;
				String questionId = paramName.substring(7); // Extract question ID
				String userAnswer = request.getParameter(paramName);
				String correctAnswer = request.getParameter("correct-" + questionId);

				// Compare user answer with the correct answer
				if (userAnswer != null && userAnswer.equals(correctAnswer)) {
					correctAnswers++;
				}
			}
		}

		// Set results in request scope and forward to a JSP
		request.setAttribute("totalQuestions", totalQuestions);
		request.setAttribute("correctAnswers", correctAnswers);
		request.getRequestDispatcher("TestResult.jsp").forward(request, response);
	}
}
