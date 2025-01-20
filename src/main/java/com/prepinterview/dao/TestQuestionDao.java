package com.prepinterview.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.prepinterview.entity.AptitudeTopic;
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
	
	public AptitudeTopic fetchTopicById(int topicId) {
		Query<AptitudeTopic> query = session.createQuery("From AptitudeTopic a where a.topicId =: topicId",
				AptitudeTopic.class);
		query.setParameter("topicId", topicId);
		return query.uniqueResult();

	}
	
	

}
