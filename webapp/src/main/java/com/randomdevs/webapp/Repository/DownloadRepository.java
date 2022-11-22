package com.randomdevs.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randomdevs.webapp.Entity.DownloadEntity;

@Repository
public interface DownloadRepository extends JpaRepository <DownloadEntity, Integer>{

}
