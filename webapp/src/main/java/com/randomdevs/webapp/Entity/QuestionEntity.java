package com.randomdevs.webapp.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_question")
public class QuestionEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int questionnumber;
	private String content;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@Column(nullable = true)
	private Set<AnswerEntity> answer;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private Set<AnswerEntity> correctanswer;

	//constructor
	public QuestionEntity() {}

	public QuestionEntity(int id, int questionnumber, String content, Set<AnswerEntity> answer, Set<AnswerEntity> correctanswer) {
		super();
		this.id = id;
		this.questionnumber = questionnumber;
		this.content = content;
		this.answer = answer;
		this.correctanswer = correctanswer;
	}

	//getters & setters
	public int getId() {
		return id;
	}

	public int getQuestionnumber() {
		return questionnumber;
	}

	public void setQuestionnumber(int questionnumber) {
		this.questionnumber = questionnumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<AnswerEntity> getAnswer() {
		return answer;
	}

	public void setAnswer(Set<AnswerEntity> answer) {
		this.answer = answer;
	}

	public Set<AnswerEntity> getCorrectanswer() {
		return correctanswer;
	}

	public void setCorrectanswer(Set<AnswerEntity> correctanswer) {
		this.correctanswer = correctanswer;
	}
}
