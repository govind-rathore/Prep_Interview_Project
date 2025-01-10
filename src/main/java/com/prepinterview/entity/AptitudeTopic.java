package com.prepinterview.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AptitudeTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicId;

	@Column(nullable = false)
	private String topicName;

	@OneToMany(mappedBy = "topic")
	private List<AptitudeQuestion> questions;

	public List<AptitudeQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<AptitudeQuestion> questions) {
		this.questions = questions;
	}

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
