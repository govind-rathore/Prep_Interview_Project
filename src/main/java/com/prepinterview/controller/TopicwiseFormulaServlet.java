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
import com.prepinterview.service.AptitudeQuestionService;


public class TopicwiseFormulaServlet extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int topicId = Integer.parseInt(req.getParameter("topicId"));
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		AptitudeQuestionService service = new AptitudeQuestionService(session);
//		AptitudeFormulas formulas = 
//
//	}
}
