package com.randomdevs.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randomdevs.webapp.Entity.PointsEntity;

@Repository
public interface PointsRepository extends JpaRepository <PointsEntity, Integer> {

}
