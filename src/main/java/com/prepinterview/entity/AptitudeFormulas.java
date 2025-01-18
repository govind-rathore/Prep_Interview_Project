//package com.prepinterview.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//@Entity
//public class AptitudeFormulas {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int formulaId;
//
//	@Column(nullable = false)
//	private String formula;
//
//	@OneToOne
//	private AptitudeTopic topic;
//
//	public int getFormulaId() {
//		return formulaId;
//	}
//
//	public String getFormula() {
//		return formula;
//	}
//
//	public AptitudeTopic getTopic() {
//		return topic;
//	}
//
//	public void setFormulaId(int formulaId) {
//		this.formulaId = formulaId;
//	}
//
//	public void setFormula(String formula) {
//		this.formula = formula;
//	}
//
//	public void setTopic(AptitudeTopic topic) {
//		this.topic = topic;
//	}
//
//}
