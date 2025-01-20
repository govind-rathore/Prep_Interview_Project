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

//	public AptitudeFormulas getFormula() {
//		return formula;
//	}
//
//	public void setFormula(AptitudeFormulas formula) {
//		this.formula = formula;
//	}

	@Column(nullable = false)
	private String topicName;

	@OneToMany(mappedBy = "topic")
	private List<AptitudeQuestion> aptitudeQuestions;

	@OneToMany(mappedBy = "topic")
	private List<TestQuestion> testQuestions;

	@OneToMany(mappedBy = "topic")
	private List<SaveResult> results;

//	@OneToOne
//	private AptitudeFormulas formula;

	public int getTopicId() {
		return topicId;
	}

	public List<AptitudeQuestion> getAptitudeQuestions() {
		return aptitudeQuestions;
	}

	public List<SaveResult> getResults() {
		return results;
	}

	public void setResults(List<SaveResult> results) {
		this.results = results;
	}

	public List<TestQuestion> getTestQuestions() {
		return testQuestions;
	}

	public void setAptitudeQuestions(List<AptitudeQuestion> aptitudeQuestions) {
		this.aptitudeQuestions = aptitudeQuestions;
	}

	public void setTestQuestions(List<TestQuestion> testQuestions) {
		this.testQuestions = testQuestions;
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
