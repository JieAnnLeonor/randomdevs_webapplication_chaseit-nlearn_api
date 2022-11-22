package com.randomdevs.webapp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_course")
public class CourseEntity {
	
	//define data members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseid;
	
	private String coursecode;
	private String coursename;
	private String coursedescription;

	private int unit;

	@ManyToOne
	@JoinColumn(name="id")
	StudentEntity student;
	
	//define constructor
	public CourseEntity() {}			

	public CourseEntity(int courseid, String coursecode, String coursename, String coursedescription, int unit,
			StudentEntity student) {
		super();
		this.courseid = courseid;
		this.coursecode = coursecode;
		this.coursename = coursename;
		this.coursedescription = coursedescription;
		this.unit = unit;
		this.student = student;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	//setters and getters
	public int getCourseid() {
		return courseid;
	}

	public String getCoursecode() {
		return coursecode;
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

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}	
}
