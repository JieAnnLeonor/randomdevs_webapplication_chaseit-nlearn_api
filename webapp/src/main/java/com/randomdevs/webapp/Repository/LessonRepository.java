package com.randomdevs.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randomdevs.webapp.Entity.LessonEntity;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity, Integer>{
	
	//user-define query
	LessonEntity findByLessonname(String lessonname);
}
