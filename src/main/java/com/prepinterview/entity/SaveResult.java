package com.prepinterview.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class SaveResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resultId;

	@Column(nullable = false)
	private int totalMarks;

	@Column(nullable = false)
	private int obtainedMarks;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime submittedAt;

	@ManyToOne
	private User user;

	@ManyToOne
	private AptitudeTopic topic;

	public int getResultId() {
		return resultId;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public User getUser() {
		return user;
	}

	public AptitudeTopic getTopic() {
		return topic;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTopic(AptitudeTopic topic) {
		this.topic = topic;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public String getFormattedSubmittedAt() {
		if (submittedAt != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return submittedAt.format(formatter);
		}
		return null;
	}
}
