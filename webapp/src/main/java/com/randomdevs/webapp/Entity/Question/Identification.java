package com.randomdevs.webapp.Entity.Question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_identification_question")
public class Identification extends QuestionEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String answer;
	
	@OneToOne
	@JoinColumn(name = "id")
	private QuestionEntity question;
	
	//constructor
	public Identification() {}

	public Identification(int questionid, int questionnumber, String content, int id, String answer, QuestionEntity question) {
		super(questionid, questionnumber, content);
		this.id = id;
		this.answer = answer;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}
}
