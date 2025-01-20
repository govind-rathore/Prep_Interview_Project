package com.prepinterview.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.prepinterview.entity.User;

public class UserDao {

	private Session session;

	public UserDao(Session session) {
		this.session = session;
	}

	public void saveUser(User user) {
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();

	}

	public User getUserByCredentials(String email, String password) {
		Query<User> query = session.createQuery("FROM User where email =:email AND password =:password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);

		User user = query.uniqueResult();

		return user;

	}

	public User getUserById(int userId) {
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, userId);
		transaction.commit();
		return user;

	}

}
