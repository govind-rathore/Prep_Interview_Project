//package com.prepinterview.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.hibernate.Session;
//
//import com.prepinterview.config.HibernateUtil;
//import com.prepinterview.entity.AptitudeFormulas;
//import com.prepinterview.service.AptitudeFormulaService;
//
//@WebServlet("/topicwise-formula")
//public class TopicwiseFormulaServlet extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int topicId = Integer.parseInt(req.getParameter("topicId"));
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		AptitudeFormulaService service = new AptitudeFormulaService(session);
//		AptitudeFormulas formulas = service.getAptitudeFormulas(topicId);
//
//		if (formulas == null) {
//			resp.getWriter().print("Sorry no data is fetched");
//		} else {
//			req.setAttribute("formulas", formulas);
//			req.getRequestDispatcher("TopicWiseFormula.jsp").forward(req, resp);
//
//		}
//
//		session.close();
//
//	}
//}
