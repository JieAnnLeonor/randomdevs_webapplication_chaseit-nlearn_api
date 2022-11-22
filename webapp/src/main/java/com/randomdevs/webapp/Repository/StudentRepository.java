package com.randomdevs.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.randomdevs.webapp.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

	//user-define query
	StudentEntity findByFirstname(String firstname);
}
