package com.randomdevs.webapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.randomdevs.webapp.Entity.AnswerEntity;
import com.randomdevs.webapp.Service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	AnswerService ansserv;
	
	//Create an Answer record
	@PostMapping("/postAnswer")
	public AnswerEntity insertAnswer(@RequestBody AnswerEntity answer) {
		return ansserv.createAnswer(answer);
	}
	
	//Get all Answer records
	@GetMapping("/getAllAnswers")
	public List<AnswerEntity> getAllAnswers(){
		return ansserv.getAllAnswers();
	}
	
	//Update a record
	@PutMapping("/putAnswer")
	public AnswerEntity updateAnswer(@RequestParam int id, @RequestBody AnswerEntity newAnswerDetails) throws Exception{
		return ansserv.putAnswer(id, newAnswerDetails);
	}
	
	//Delete a record
	@DeleteMapping("/deleteAnswer/{id}")
	public String deleteAnswer(@RequestParam int id) {
		return ansserv.deleteAnswer(id);
	}
}
