package com.prepinterview.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prepinterview.entity.AptitudeTopic;

public class AptitudeTopicDao {

	private Session session;

	public AptitudeTopicDao(Session session) {
		this.session = session;

	}

	public void saveAptitudeTopic(AptitudeTopic topic) {
		Transaction transaction = session.beginTransaction();

		session.save(topic);

		transaction.commit();

	}

}
