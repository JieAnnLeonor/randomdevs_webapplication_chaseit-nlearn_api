package com.randomdevs.webapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.randomdevs.webapp.Service.TeacherService;
import com.randomdevs.webapp.Entity.TeacherEntity;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherService tserve;
	
	//create Teacher record
	@PostMapping("/postTeacher")
	public TeacherEntity insertTeacher(@RequestBody TeacherEntity Teacher) {
		return tserve.insertTeacher(Teacher);
	}
	
	//get all records
	@GetMapping("/getAllTeachers")
	public List<TeacherEntity> getAllTeachers(){
		return tserve.getAllTeachers();
	}
	
	//get record by firstname
	@GetMapping("/getByFirstName")
	public TeacherEntity findByFirstname(@RequestParam String firstname) {
		return tserve.findByFirstname(firstname);
	}
	
	//update Teacher record
	@PutMapping("/putTeacher")
	public TeacherEntity putTeacher(@RequestParam int id, @RequestBody TeacherEntity newTeacherDetails) throws Exception {
		return tserve.putTeacher(id, newTeacherDetails);
	}
	
	//delete Teacher record
	@DeleteMapping("/deleteTeacher/{id}")
	public String deleteTeacher(int id) {
		return tserve.deleteTeacher(id);
	}
}
