package com.prepinterview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AptitudeQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;

	@Column(nullable = false)
	private String question;

	@Column(nullable = false)
	private String optionA;

	@Column(nullable = false)
	private String optionB;

	@Column(nullable = false)
	private String optionC;

	@Column(nullable = false)
	private String optionD;

	@Column(nullable = false)
	private char correctOption;

	private String solution;

	@ManyToOne
	private AptitudeTopic topic;

	public int getQuestionId() {
		return questionId;
	}

	public String getQuestion() {
		return question;
	}

	public String getOptionA() {
		return optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public char getCorrectOption() {
		return correctOption;
	}

	public String getSolution() {
		return solution;
	}

	public AptitudeTopic getTopic() {
		return topic;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public void setCorrectOption(char correctOption) {
		this.correctOption = correctOption;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public void setTopic(AptitudeTopic topic) {
		this.topic = topic;
	}

}
