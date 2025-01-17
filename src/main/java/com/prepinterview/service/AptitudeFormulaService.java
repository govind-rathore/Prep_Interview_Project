package com.prepinterview.service;

import org.hibernate.Session;

import com.prepinterview.dao.AptitudeFormulaDao;
import com.prepinterview.entity.AptitudeFormulas;

public class AptitudeFormulaService {

	private AptitudeFormulaDao aptitudeFormulaDao;

	public AptitudeFormulaService(Session session) {
		aptitudeFormulaDao = new AptitudeFormulaDao(session);
	}

	public void addformulas(AptitudeFormulas formulas) {
		aptitudeFormulaDao.saveFormulas(formulas);

	}

	public AptitudeFormulas getAptitudeFormulas(int topicId) {
		return aptitudeFormulaDao.fetchFormulas(topicId);

	}

}
