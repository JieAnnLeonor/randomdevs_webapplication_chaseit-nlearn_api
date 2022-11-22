package com.randomdevs.webapp.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomdevs.webapp.Entity.QuizEntity;
import com.randomdevs.webapp.Repository.QuizRepository;

@Service
public class QuizService {
	@Autowired	
	QuizRepository qrepo;
	
	//Create a Quiz record
	public QuizEntity insertQuiz(QuizEntity Quiz) {
		return qrepo.save(Quiz);
	}	
	
	//Read all Quiz records
	public List<QuizEntity> getAllQuizzes() {
		return qrepo.findAll();
	}
	
	//Read Quiz record by name
	public QuizEntity findByQuizname(String quizname) {
		if (qrepo.findByQuizname(quizname) != null) 
			return qrepo.findByQuizname(quizname);
		else 
			return null;
	}

	//Update a Quiz record
	public QuizEntity putQuiz(int id, QuizEntity newQuizDetails) throws Exception{
			
		QuizEntity quiz = new QuizEntity();
			
		try {
			quiz = qrepo.findById(id).get();
				
			quiz.setQuizname(newQuizDetails.getQuizname());
			quiz.setQuestion(newQuizDetails.getQuestion());
			
			return qrepo.save(quiz);
				
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + id + " does not exist!");
		}
	}
	
	//Delete a Quiz record
	public String deleteQuiz(int id) {
		String msg;
		if(qrepo.findById(id) != null) {
			qrepo.deleteById(id);
			msg = "Quiz ID Number " + id + " is successfully deleted!";
		}
		else msg = "Quiz ID Number " + id + " is NOT found!";
		return msg;
	}
}
