package com.prepinterview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.AptitudeFormulas;
import com.prepinterview.entity.AptitudeTopic;
import com.prepinterview.service.AptitudeFormulaService;
import com.prepinterview.service.FetchTopicsService;

@WebServlet("/add-formulas")
public class AddFormulasServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int topicId = Integer.parseInt(req.getParameter("topicId"));
		String formula = req.getParameter("formula");

		AptitudeFormulas formulas = new AptitudeFormulas();
		formulas.setFormula(formula);

		// Fetching AptitudeTopic Object to insert in aptitudeQuestions
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		FetchTopicsService topicsService = new FetchTopicsService(session1);
		AptitudeTopic topic = topicsService.getTopicById(topicId);

		session1.close();

		// Adding AptitudeTopic Object to aptitudeQuestions
		formulas.setTopic(topic);

		Session session2 = HibernateUtil.getSessionFactory().openSession();
		AptitudeFormulaService formulaService = new AptitudeFormulaService(session2);
		formulaService.addformulas(formulas);

		session2.close();
	}

}
