package com.randomdevs.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randomdevs.webapp.Entity.AnswerEntity;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer>{

}
