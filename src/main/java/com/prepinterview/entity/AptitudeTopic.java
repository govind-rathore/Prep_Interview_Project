package com.prepinterview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AptitudeTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicId;

	@Column(nullable = false)
	private String topicName;

	public int getTopicId() {
		return topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
