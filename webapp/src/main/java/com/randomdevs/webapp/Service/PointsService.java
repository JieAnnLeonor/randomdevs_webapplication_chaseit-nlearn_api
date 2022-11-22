package com.randomdevs.webapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomdevs.webapp.Entity.PointsEntity;
import com.randomdevs.webapp.Repository.PointsRepository;

@Service
public class PointsService {
	
	@Autowired
	PointsRepository pointsRepo;
	
	//C-Create or insert a points record
	public PointsEntity insertPoints(PointsEntity points) {
		return pointsRepo.save(points);
	}
	
	//R-Read all record of points
	public List<PointsEntity> getAllPoints() {
		return pointsRepo.findAll();
	}
	
	//D - Delete a point record
	public String deletePoints(int id) {
		String msg;
		if(pointsRepo.findById(id) != null) {      //Step 1 - find the record
			pointsRepo.deleteById(id);             //Step 2 - delete the record
			
			msg = "Lesson ID Number " + id + " is successfully deleted!";
		}
		else {
			msg = "Lesson ID Number " + id + " is NOT found!";
		}		
		return msg;
	}
}
