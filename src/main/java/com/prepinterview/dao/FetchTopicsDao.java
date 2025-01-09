package com.prepinterview.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.prepinterview.entity.AptitudeTopic;

public class FetchTopicsDao {

	private Session session;

	public FetchTopicsDao(Session session) {
		this.session = session;
	}

	public List<AptitudeTopic> fetchTopics() {
		Query<AptitudeTopic> query = session.createQuery("From AptitudeTopic", AptitudeTopic.class);
		return query.list();

	}

}
