package com.prepinterview.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.prepinterview.entity.AptitudeFormulas;
import com.prepinterview.entity.AptitudeQuestion;

public class AptitudeFormulaDao {

	private Session session;

	public AptitudeFormulaDao(Session session) {
		this.session = session;
	}

	public void saveFormulas(AptitudeFormulas formulas) {
		Transaction transaction = session.beginTransaction();
		session.save(formulas);
		transaction.commit();

	}

	public AptitudeFormulas fetchFormulas(int topicId) {
		// Create query to fetch questions based on topicId
		Query<AptitudeFormulas> query = session.createQuery("FROM AptitudeFormulas aq WHERE aq.topicId = :topicId",
				AptitudeFormulas.class);

		// Set the parameter for topicId
		query.setParameter("topicId", topicId);

		return query.uniqueResult();

	}

}
