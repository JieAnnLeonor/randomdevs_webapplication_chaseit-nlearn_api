package com.randomdevs.webapp.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomdevs.webapp.Entity.DownloadEntity;
import com.randomdevs.webapp.Repository.DownloadRepository;

@Service
public class DownloadService {
	
	@Autowired
	DownloadRepository downloadResourceRepo;
	
	//C-Create or insert a DownloadResource record
	public DownloadEntity insertDownloadResource(DownloadEntity DownloadResource) {
		return downloadResourceRepo.save(DownloadResource);
	}
	
	//R-Read all record of DownloadResource
	public List<DownloadEntity> getAllDownloadResource() {
		return downloadResourceRepo.findAll();
	}
	
	//U-Update a DownloadResource record
	public DownloadEntity putDownloadResource(int id, DownloadEntity newDownloadResourceDeatails) throws Exception{
		
		DownloadEntity downloadResource = new DownloadEntity();
		
		try {
			//steps in updating
			//step 1 -search the id number of the lesson
			downloadResource = downloadResourceRepo.findById(id).get();
			
			//Step 2 - update the record
			downloadResource.setDescription(newDownloadResourceDeatails.getDescription());
			downloadResource.setRequiredPoints(newDownloadResourceDeatails.getRequiredPoints());
			
			//Step 3 - save the information and return the value --refer to finally block
			return downloadResourceRepo.save(downloadResource);
			
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + id + " does not exist!");
		}
	}
	
	//D - Delete a DownloadResource record
	public String deleteDownloadResource(int id) {
		String msg;
		if(downloadResourceRepo.findById(id) != null) {      //Step 1 - find the record
			downloadResourceRepo.deleteById(id);             //Step 2 - delete the record
			
			msg = "Lesson ID Number " + id + " is successfully deleted!";
		}
		else {
			msg = "Lesson ID Number " + id + " is NOT found!";
		}		
		return msg;
	}
}
