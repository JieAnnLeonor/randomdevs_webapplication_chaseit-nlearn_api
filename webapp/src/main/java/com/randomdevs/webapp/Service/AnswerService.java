package com.randomdevs.webapp.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomdevs.webapp.Entity.AnswerEntity;
import com.randomdevs.webapp.Repository.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	AnswerRepository ansrepo;
	
	//create
	public AnswerEntity createAnswer(AnswerEntity answer) {
		return ansrepo.save(answer);
	}
	
	//read
	public List<AnswerEntity> getAllAnswers(){
		return ansrepo.findAll();
	}
	
	//update
	public AnswerEntity putAnswer(int id, AnswerEntity newAnswerDetails) throws Exception{
		AnswerEntity answer = new AnswerEntity();
		
		try {
			answer = ansrepo.findById(id).get();
			
			answer.setContent(newAnswerDetails.getContent());
			
			return answer;
			
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + id + " does not exist!");
		}
	}
	
	//delete
	public String deleteAnswer(int id) {
		String msg;
		if(ansrepo.findById(id) != null) {
			ansrepo.deleteById(id);
			msg = "Answer ID Number " + id + " is successfully deleted!";
		}
		else msg = "Answer ID Number " + id + " does not exist!";
		
		return msg;
	}
}
