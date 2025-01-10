package com.prepinterview.service;

import java.util.List;

import org.hibernate.Session;

import com.prepinterview.dao.AptitudeQuestionDao;
import com.prepinterview.entity.AptitudeQuestion;
import com.prepinterview.entity.AptitudeTopic;

public class AptitudeQuestionService {

	private AptitudeQuestionDao questionDao;

	public AptitudeQuestionService(Session session) {
		questionDao = new AptitudeQuestionDao(session);

	}

	public void addQuestion(AptitudeQuestion question) {
		questionDao.saveQuestion(question);

	}

	public List<AptitudeQuestion> getQuestionsListByTopicId(int topicId) {
		return questionDao.fetchQuestionsById(topicId);

	}
}
