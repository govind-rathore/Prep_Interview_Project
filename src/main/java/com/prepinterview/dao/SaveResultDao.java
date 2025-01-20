package com.prepinterview.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prepinterview.entity.SaveResult;

public class SaveResultDao {

	private Session session;

	public SaveResultDao(Session session) {
		this.session = session;
	}

	public void saveResult(SaveResult result) {
		Transaction transaction = session.beginTransaction();
		session.save(result);
		transaction.commit();

	}

}
