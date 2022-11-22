package com.randomdevs.webapp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_lesson")
public class LessonEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String lessonname;
	private String author;
	private int chapter;
	private String content;
	
	public LessonEntity() {}
	
	public LessonEntity(int id, String lessonname, String author, int chapter, String content) {
		super();
		this.id = id;
		this.lessonname = lessonname;
		this.author = author;
		this.chapter = chapter;
		this.content = content;
	}
	public String getLessonname() {
		return lessonname;
	}
	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}
	public String getAuthor() {
		return author;
	}
	public int getChapter() {
		return chapter;
	}
	public String getContent() {
		return content;
	}
	public int getId() {
		return id;
	}
}
