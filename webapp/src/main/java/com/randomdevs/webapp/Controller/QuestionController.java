package com.randomdevs.webapp.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.randomdevs.webapp.Entity.QuestionEntity;
import com.randomdevs.webapp.Service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService queserv;
	
	//Create a Question
	@PostMapping("/postQuestion")
	public QuestionEntity insertQuestion(@RequestBody QuestionEntity Question) {
		return queserv.insertQuestion(Question);
	}
	
	//Get all Question records
	@GetMapping("/getAllQuestions")
	public List<QuestionEntity> getAllQuestionzes() {
		return queserv.getAllQuestions();
	}
	
	//Update a record
	@PutMapping("/putQuestion")
	public QuestionEntity putQuestion(@RequestParam int id, @RequestBody QuestionEntity newQuestionDetails) throws Exception{
		return queserv.putQuestion(id, newQuestionDetails);
	}
		
	//Delete a record
	@DeleteMapping("/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable int id) {
		return queserv.deleteQuestion(id);
	}
}
