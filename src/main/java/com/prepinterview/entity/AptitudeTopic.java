package com.prepinterview.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AptitudeTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicId;

	public AptitudeFormulas getFormula() {
		return formula;
	}

	public void setFormula(AptitudeFormulas formula) {
		this.formula = formula;
	}

	@Column(nullable = false)
	private String topicName;

	@OneToMany(mappedBy = "topic")
	private List<AptitudeQuestion> questions;

	@OneToOne
	private AptitudeFormulas formula;

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
