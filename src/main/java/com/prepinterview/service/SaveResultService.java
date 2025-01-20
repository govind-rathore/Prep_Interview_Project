package com.prepinterview.service;

import org.hibernate.Session;

import com.prepinterview.dao.SaveResultDao;
import com.prepinterview.entity.SaveResult;

public class SaveResultService {

	private SaveResultDao resultDao;

	public SaveResultService(Session session) {
		resultDao = new SaveResultDao(session);
	}
	
	public void saveResult(SaveResult result) {
		resultDao.saveResult(result);
		
	}

}
