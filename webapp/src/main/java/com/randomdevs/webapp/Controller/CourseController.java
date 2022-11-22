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

import com.randomdevs.webapp.Entity.CourseEntity;
import com.randomdevs.webapp.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService cserv;
	
	//C-Create or insert a course
	@PostMapping("/postCourse")
	public CourseEntity insertCourse(@RequestBody CourseEntity course) {
		return cserv.insertCourse(course);
	} 

	//R-Read all records from tbl_course
	@GetMapping("/getAllCourses")
	public List<CourseEntity> getAllCourses() {
		return cserv.getAllCourses();
	} 
	
	//Read or search a record by code
	@GetMapping("/getByCoursename")
	public CourseEntity findByCoursename(@RequestParam String coursename){
		return cserv.findByCoursename(coursename);
	}
	
	//Update a record
	@PutMapping("/putCourse")
	public CourseEntity putCourse(@RequestParam int id, @RequestBody CourseEntity newCourseDeatails) throws Exception{
		return cserv.putCourse(id, newCourseDeatails);
	}
		
	//Delete a record
	@DeleteMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable int id) {
		return cserv.deleteCourse(id);
	}	
}
