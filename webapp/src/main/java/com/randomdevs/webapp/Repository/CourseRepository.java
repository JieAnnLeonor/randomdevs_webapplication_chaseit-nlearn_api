package com.randomdevs.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.randomdevs.webapp.Entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>{

	//user-define query
	CourseEntity findByCoursename(String coursename);
}
