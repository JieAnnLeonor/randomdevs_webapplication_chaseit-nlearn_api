package com.randomdevs.webapp.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_course")
public class CourseEntity {
	
	//define data members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String coursecode;
	private String coursename;
	private String coursedescription;

	private int unit;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "t_course")
	Set<TeacherEntity> teacher;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private List<LessonEntity> lessons;

	//define constructor
	public CourseEntity() {}	


	@Override
	public String toString() {
		return super.toString();
	}
	
	//setters and getters


	public String getCoursecode() {
		return coursecode;
	}

	public CourseEntity(int id, String coursecode, String coursename, String coursedescription, int unit,
			List<LessonEntity> lessons) {
		super();
		this.id = id;
		this.coursecode = coursecode;
		this.coursename = coursename;
		this.coursedescription = coursedescription;
		this.unit = unit;
		this.lessons = lessons;
	}


	public int getId() {
		return id;
	}


	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursedescription() {
		return coursedescription;
	}

	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
	
	public List<LessonEntity> getLessons() {
		return lessons;
	}

	public void setLessons(List<LessonEntity> lessons) {
		this.lessons = lessons;
	}
}
