package com.randomdevs.webapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.randomdevs.webapp.Entity.StudentEntity;
import com.randomdevs.webapp.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stserv;
	
	//printHelloStudent
	@GetMapping("/print")
	public String printHelloStudent() {
		return "Hello, Students!";
	}
	
	//C-Create or insert a student record
	@PostMapping("/postStudent")
	public StudentEntity insertStudent(@RequestBody StudentEntity student) {
		return stserv.insertStudent(student);
	} 
	
	//R-Read all records from tbl_student
	@GetMapping("/getAllStudents")
	public List<StudentEntity> getAllStudents() {
		return stserv.getAllStudents();
	} 
	
	//Read or search a record by firstname
	@GetMapping("/getByFirstname")
	public StudentEntity findByFirstname(@RequestParam String firstname){
		return stserv.findByFirstname(firstname);
	}
	
	//Update a record
	@PutMapping("/putStudent")
	public StudentEntity putStudent(@RequestParam int id, @RequestBody StudentEntity newStudentDeatails) throws Exception{
		return stserv.putStudent(id, newStudentDeatails);
	}
	
	//Delete a record
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return stserv.deleteStudent(id);
	}	
}
