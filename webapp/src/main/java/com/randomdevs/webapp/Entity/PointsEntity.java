package com.randomdevs.webapp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_points")
public class PointsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int points;
	
	public PointsEntity() {}
	
	public PointsEntity(int id, int points) {
		super();
		this.id = id;
		this.points = points;
	}


	public int getId() {
		return id;
	}

	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}
	
	public int addPoints(int points) {
		
		int totalPoints = getPoints() + points;
		
		return totalPoints;
	}
	
	public int deductPoints(int points) {
		
		int totalPoints = getPoints() - points;
		
		return totalPoints;
	}
	
}
