package com.prepinterview.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.prepinterview.entity.AptitudeQuestion;

public class AptitudeQuestionDao {

	private Session session;

	public AptitudeQuestionDao(Session session) {
		this.session = session;
	}

	public void saveQuestion(AptitudeQuestion questions) {
		Transaction transaction = session.beginTransaction();
		session.save(questions);
		transaction.commit();

	}

	public List<AptitudeQuestion> fetchQuestionsById(int topicId) {
		// Create query to fetch questions based on topicId
		Query<AptitudeQuestion> query = session.createQuery("FROM AptitudeQuestion aq WHERE aq.topicId = :topicId",
				AptitudeQuestion.class);

		// Set the parameter for topicId
		query.setParameter("topicId", topicId);

		// Execute the query and return the list of AptitudeQuestions
		return query.list();
	}

}
