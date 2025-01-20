package com.prepinterview.service;

import org.hibernate.Session;

import com.prepinterview.dao.TestQuestionDao;
import com.prepinterview.entity.TestQuestion;

public class TestQuestionService {

	private TestQuestionDao questionDao;

	public TestQuestionService(Session session) {
		questionDao = new TestQuestionDao(session);

	}

	public void addQuestion(TestQuestion question) {
		questionDao.saveQuestion(question);

	}

}
