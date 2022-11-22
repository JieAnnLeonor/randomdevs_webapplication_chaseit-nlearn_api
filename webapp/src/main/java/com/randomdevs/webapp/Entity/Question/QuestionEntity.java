package com.randomdevs.webapp.Entity.Question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_question")
public abstract class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int questionnumber;
	private String content;
	
	//constructor
	public QuestionEntity() {}

	public QuestionEntity(int id, int questionnumber, String content) {
		this.id = id;
		this.questionnumber = questionnumber;
		this.content = content;
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
}
