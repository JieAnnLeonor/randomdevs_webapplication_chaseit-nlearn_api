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

import com.randomdevs.webapp.Entity.LessonEntity;
import com.randomdevs.webapp.Service.LessonService;

@RestController
@RequestMapping("/lesson")
public class LessonController {
	
	@Autowired
	LessonService ltserv;
	
	//C-Create or insert a lesson record
	@PostMapping("/postLesson")
	public LessonEntity insertLesson(@RequestBody LessonEntity lesson) {
		return ltserv.insertLesson(lesson);
	} 
	
	//R-Read all records from tbl_student
	@GetMapping("/getAllLessons")
	public List<LessonEntity> getAllLessons() {
		return ltserv.getAllLessons();
	} 
	
	//Read or search a record by lessonname
	@GetMapping("/getByLessonname")
	public LessonEntity findByLessonname(@RequestParam String lessonname){
		return ltserv.findByLessonname(lessonname);
	}
	
	//Update a record
	@PutMapping("/putLesson")
	public LessonEntity putLesson(@RequestParam int id, @RequestBody LessonEntity newLessonDeatails) throws Exception{
		return ltserv.putLesson(id, newLessonDeatails);
	}
	
	//Delete a record
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteLesson(@PathVariable int id) {
		return ltserv.deleteLesson(id);
	}	
}
