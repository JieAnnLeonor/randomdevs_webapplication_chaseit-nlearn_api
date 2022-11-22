package com.randomdevs.webapp.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomdevs.webapp.Entity.LessonEntity;
import com.randomdevs.webapp.Repository.LessonRepository;

@Service
public class LessonService {
	/*this class contains all the business logic of your systems
	 * Create a student record
	 * Read student record/s by id or firstname
	 * Update a student record
	 * Delete a student
	 */
		
	@Autowired
	LessonRepository lrepo;;
	
	//C-Create or insert a lesson record
	public LessonEntity insertLesson(LessonEntity lesson) {
		return lrepo.save(lesson);
	}
			
	//R-Read a record from the table named tbl_student
	public List<LessonEntity> getAllLessons() {
		return lrepo.findAll();
	}
	
	//R-Read or search lesson record by lessonname
	public LessonEntity findByLessonname(String lessonname) {
		if (lrepo.findByLessonname(lessonname) != null) 
			return lrepo.findByLessonname(lessonname);
		else 
			return null;
	}
	
	//U-Update a student record
	public LessonEntity putLesson(int id, LessonEntity newLessonDeatails) throws Exception{
		
		LessonEntity lesson = new LessonEntity();
		
		try {
			//steps in updating
			//step 1 -search the id number of the lesson
			lesson = lrepo.findById(id).get();
			
			//Step 2 - update the record
			lesson.setLessonname(newLessonDeatails.getLessonname());
			
			//Step 3 - save the information and return the value --refer to finally block
			return lrepo.save(lesson);
			
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + id + " does not exist!");
		}
	}
	
	//D - Delete a lesson record
	public String deleteLesson(int id) {
		String msg;
		if(lrepo.findById(id) != null) {      //Step 1 - find the record
			lrepo.deleteById(id);             //Step 2 - delete the record
		
			msg = "Lesson ID Number " + id + " is successfully deleted!";
		}
		else {
			msg = "Lesson ID Number " + id + " is NOT found!";
		}		
		return msg;
	}
}
