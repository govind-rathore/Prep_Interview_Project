package com.prepinterview.service;

import org.hibernate.Session;

import com.prepinterview.dao.UserDao;
import com.prepinterview.entity.User;

public class UserService {

	private UserDao userDao;

	public UserService(Session session) {
		userDao = new UserDao(session);

	}

	public void registerUser(User user) {
		userDao.saveUser(user);

	}

	public User loginUser(String email, String password) {
		return userDao.getUserByCredentials(email, password);

	}

	public User getUserById(int userID) {
		return userDao.getUserById(userID);

	}

}
