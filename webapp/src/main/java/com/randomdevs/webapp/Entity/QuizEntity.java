package com.randomdevs.webapp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import com.randomdevs.webapp.Entity.Question.QuestionEntity;

import java.util.Set;

@Entity
@Table(name = "tbl_quiz")
public class QuizEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String quizname;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private Set<QuestionEntity> question;
	
	//constructors
	public QuizEntity() {}
	
	public QuizEntity(int id, String quizname, Set<QuestionEntity> question) {
		super();
		this.id = id;
		this.quizname = quizname;
		this.question = question;
	}
	
	//getters & setters
	public int getId() {
		return id;
	}

	public String getQuizname() {
		return quizname;
	}

	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}

	public Set<QuestionEntity> getQuestion() {
		return question;
	}

	public void setQuestion(Set<QuestionEntity> question) {
		this.question = question;
	}
}
