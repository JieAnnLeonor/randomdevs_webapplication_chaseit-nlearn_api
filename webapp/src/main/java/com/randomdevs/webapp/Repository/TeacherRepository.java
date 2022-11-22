package com.randomdevs.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randomdevs.webapp.Entity.TeacherEntity;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer>{
	TeacherEntity findByFirstname(String firstname);
}
