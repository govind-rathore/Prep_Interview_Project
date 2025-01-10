package com.prepinterview.service;

import java.util.List;

import org.hibernate.Session;

import com.prepinterview.dao.FetchTopicsDao;
import com.prepinterview.entity.AptitudeTopic;

public class FetchTopicsService {
	FetchTopicsDao fetchDao = null;

	public FetchTopicsService(Session session) {
		fetchDao = new FetchTopicsDao(session);

	}

	public List<AptitudeTopic> getTopics() {
		return fetchDao.fetchTopics();

	}

	public AptitudeTopic getTopicById(int topicId) {
		return fetchDao.fetchTopicById(topicId);

	}

}
