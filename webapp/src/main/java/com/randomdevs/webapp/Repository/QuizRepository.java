package com.randomdevs.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randomdevs.webapp.Entity.QuizEntity;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Integer>{
	QuizEntity findByQuizname(String quizname);
}
