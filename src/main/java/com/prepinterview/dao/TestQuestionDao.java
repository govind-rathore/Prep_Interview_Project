package com.prepinterview.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prepinterview.entity.TestQuestion;

public class TestQuestionDao {

	private Session session;

	public TestQuestionDao(Session session) {
		this.session = session;

	}

	public void saveQuestion(TestQuestion questions) {
		Transaction transaction = session.beginTransaction();
		session.save(questions);
		transaction.commit();

	}

}
