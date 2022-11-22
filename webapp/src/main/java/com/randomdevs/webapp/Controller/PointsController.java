package com.randomdevs.webapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.randomdevs.webapp.Entity.PointsEntity;
import com.randomdevs.webapp.Service.PointsService;

@RestController
@RequestMapping("/points")
public class PointsController {

	@Autowired
	PointsService pointsService;
	
	//C - Create or insert a Points record
	@PostMapping("/postPoints")
	public PointsEntity insertPoints(@RequestBody PointsEntity points) {
		return pointsService.insertPoints(points);
	}
		
	//Read all records
	@GetMapping("/getAllPointss")
	public List<PointsEntity> getAllPoints(){
		return pointsService.getAllPoints();
	}
		
	//Delete a record
	@DeleteMapping("/deletePoints/{id}")
	public String deletePoints(@PathVariable int id) {
		return pointsService.deletePoints(id);
	}
}
