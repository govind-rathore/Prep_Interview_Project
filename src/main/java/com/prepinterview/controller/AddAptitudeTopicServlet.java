package com.prepinterview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.persister.walking.spi.MetamodelGraphWalker;

import com.prepinterview.config.HibernateUtil;
import com.prepinterview.entity.AptitudeTopic;
import com.prepinterview.service.AptitudeTopicService;

@WebServlet("/addAptitudeTopic")
public class AddAptitudeTopicServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String topicName = req.getParameter("topicName");

		AptitudeTopic topic = new AptitudeTopic();
		topic.setTopicName(topicName);

		Session session = HibernateUtil.getSessionFactory().openSession();
		AptitudeTopicService topicService = new AptitudeTopicService(session);
		topicService.addAptitudeTopic(topic);
		resp.getWriter().write("Topic Added Successfully!!");

	}

}
