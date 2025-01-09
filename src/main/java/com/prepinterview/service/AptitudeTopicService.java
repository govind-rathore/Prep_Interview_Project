package com.prepinterview.service;

import org.hibernate.Session;

import com.prepinterview.dao.AptitudeTopicDao;
import com.prepinterview.entity.AptitudeTopic;

public class AptitudeTopicService {

	private AptitudeTopicDao topicDao;

	public AptitudeTopicService(Session session) {

		topicDao = new AptitudeTopicDao(session);
	}
	
	
	public void addAptitudeTopic(AptitudeTopic topic) {
		topicDao.saveAptitudeTopic(topic);
		
	}

}
