package com.randomdevs.webapp.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomdevs.webapp.Entity.QuestionEntity;
import com.randomdevs.webapp.Repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository quesrepo;
	
	//create
	public QuestionEntity insertQuestion(QuestionEntity question) {
		return quesrepo.save(question);
	}
	
	//read
	public List<QuestionEntity> getAllQuestions(){
		return quesrepo.findAll();
	}
	
	//update
	public QuestionEntity putQuestion(int id, QuestionEntity newQuestionDetails) throws Exception{
		QuestionEntity question = new QuestionEntity();
		
		try {
			question = quesrepo.findById(id).get();
			
			question.setQuestionnumber(newQuestionDetails.getQuestionnumber());
			question.setContent(newQuestionDetails.getContent());
			question.setAnswer(newQuestionDetails.getAnswer());
			question.setCorrectanswer(newQuestionDetails.getCorrectanswer());
			
			return question;
			
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + id + " does not exist!");
		}
	}
	
	//delete
	public String deleteQuestion(int id) {
		String msg;
		if(quesrepo.findById(id) != null) {
			quesrepo.deleteById(id);
			msg = "Question ID Number " + id + " is successfully deleted!";
		}
		else msg = "Question ID Number " + id + " does not exist!";
		
		return msg;
	}
}
