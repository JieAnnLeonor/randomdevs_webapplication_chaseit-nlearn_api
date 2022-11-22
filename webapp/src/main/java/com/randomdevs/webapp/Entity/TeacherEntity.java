package com.randomdevs.webapp.Entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_teacher")
public class TeacherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstname;
	private String lastname;
	private String middlename;
	private String contact;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<CourseEntity> course;
	
	@JsonIgnore
	@OneToMany(mappedBy="teacherRes", cascade = CascadeType.ALL)
	Set<ResourcesEntity> resources;
	
	//constructor
	public TeacherEntity() {}

	public TeacherEntity(int id, String firstname, String lastname, String middlename, String contact,
			Set<CourseEntity> course, Set<ResourcesEntity> resources) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.contact = contact;
		this.course = course;
		this.resources = resources;
	}

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Set<CourseEntity> getCourse() {
		return course;
	}

	public void setCourse(Set<CourseEntity> course) {
		this.course = course;
	}

	public Set<ResourcesEntity> getResources() {
		return resources;
	}

	public void setResources(Set<ResourcesEntity> resources) {
		this.resources = resources;
	}

}
