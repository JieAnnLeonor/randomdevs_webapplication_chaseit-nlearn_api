package com.randomdevs.webapp.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_student")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstname;
	private String lastname;
	private String middlename;
	private int yearlevel;
	private String contact;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<CourseEntity> course;

	public StudentEntity() {}

	//define constructor
	public StudentEntity(int id, String firstname, String lastname, String middlename, int yearlevel, String contact,
			Set<CourseEntity> course) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.yearlevel = yearlevel;
		this.contact = contact;
		this.course = course;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	//getter and setter methods
	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMiddlename() {
		return middlename;
	}

	public int getYearlevel() {
		return yearlevel;
	}

	public void setYearlevel(int yearlevel) {
		this.yearlevel = yearlevel;
	}	

	public Set<CourseEntity> getCourse() {
		return course;
	}

	public void setCourse(Set<CourseEntity> course) {
		this.course = course;
	}
}
