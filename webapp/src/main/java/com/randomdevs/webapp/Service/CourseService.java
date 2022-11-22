package com.randomdevs.webapp.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomdevs.webapp.Entity.CourseEntity;
import com.randomdevs.webapp.Repository.CourseRepository;

@Service
public class CourseService {
	/*this class contains all the business logic of your systems
	 * Create a student record
	 * Read student record/s by id or firstname
	 * Update a student record
	 * Delete a student
	 */
		
	@Autowired	
	CourseRepository crepo;
	
	//C-Create or insert a course record
	//C-Create or insert a student record
	public CourseEntity insertCourse(CourseEntity course) {
		return crepo.save(course);
	}	
	
	//R-Read a record from the table named tbl_course
	public List<CourseEntity> getAllCourses() {
		return crepo.findAll();
	}
	
	//R-Read or search course record by code
	public CourseEntity findByCoursename(String coursename) {
		if (crepo.findByCoursename(coursename) != null) 
			return crepo.findByCoursename(coursename);
		else 
			return null;
	}

	//U-Update a student record
	public CourseEntity putCourse(int id, CourseEntity newCourseDeatails) throws Exception{
			
		CourseEntity course = new CourseEntity();
			
		try {
			//steps in updating
			//step 1 -search the id number of the student
			course = crepo.findById(id).get();
				
			//Step 2 - update the record
			course.setCoursecode(newCourseDeatails.getCoursecode());
			course.setCoursename(newCourseDeatails.getCoursename());
			course.setCoursedescription(newCourseDeatails.getCoursedescription());
			course.setUnit(newCourseDeatails.getUnit());
			
			//Step 3 - save the information and return the value --refer to finally block
			return crepo.save(course);
				
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + id + " does not exist!");
		}
	}
	
	//D - Delete a student record
	public String deleteCourse(int id) {
		String msg;
		if(crepo.findById(id) != null) {      //Step 1 - find the record
			crepo.deleteById(id);             //Step 2 - delete the record
			
			msg = "Course ID Number " + id + " is successfully deleted!";
		}
		else {
			msg = "Course ID Number " + id + " is NOT found!";
		}		
		return msg;
	}
}
