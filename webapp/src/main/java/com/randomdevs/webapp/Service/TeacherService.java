package com.randomdevs.webapp.Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.randomdevs.webapp.Entity.TeacherEntity;
import com.randomdevs.webapp.Repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository trepo;
	
	//Create Teacher record
	public TeacherEntity insertTeacher(TeacherEntity teacher) {
		return trepo.save(teacher);
	}
	
	//Read Teacher records
	public List<TeacherEntity> getAllTeachers() {
		return trepo.findAll();
	}
	
	//Read Teacher record by firstname
	public TeacherEntity findByFirstname(String firstname) {
		if (trepo.findByFirstname(firstname) != null) 
			return trepo.findByFirstname(firstname);
		else 
			return null;
	}
	
	//Update a Teacher record
	public TeacherEntity putTeacher(int id, TeacherEntity newTeacherDetails) throws Exception{
		
		TeacherEntity teacher = new TeacherEntity();
		
		try {
			teacher = trepo.findById(id).get();
			
			teacher.setContact(newTeacherDetails.getContact());
			
			return trepo.save(teacher);
			
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + id + " does not exist!");
		}
	}
	
	//Delete a Teacher record
	public String deleteTeacher(int id) {
		String msg;
		if(trepo.findById(id) != null) {
			trepo.deleteById(id);
			msg = "Teacher ID Number " + id + " is successfully deleted!";
		}
		else msg = "Teacher ID Number " + id + " is NOT found!";
		
		return msg;
	}
}
