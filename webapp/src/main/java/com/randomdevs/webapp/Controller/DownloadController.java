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

import com.randomdevs.webapp.Entity.DownloadEntity;
import com.randomdevs.webapp.Service.DownloadService;

@RestController
@RequestMapping("/downloads")
public class DownloadController {

	@Autowired
	DownloadService downloadResourceService;
	
	//C - Create or insert a DownloadResource record
	@PostMapping("/postDownloadResource")
	public DownloadEntity insertDownloadResource(@RequestBody DownloadEntity downloadResource) {
		return downloadResourceService.insertDownloadResource(downloadResource);
	}
		
	//Read all records
	@GetMapping("/getAllDownloadResourcezes")
	public List<DownloadEntity> getAllDownloadResource(){
		return downloadResourceService.getAllDownloadResource();
	}
		
	//Update a record
	@PutMapping("/putDownloadResource")
	public DownloadEntity putDownloadResource(@RequestParam int id,@RequestBody DownloadEntity newDownloadResourceDetails) throws Exception{
		return downloadResourceService.putDownloadResource(id, newDownloadResourceDetails);
	}
		
	//Delete a record
	@DeleteMapping("/deleteDownloadResource/{id}")
	public String deleteDownloadResource(@PathVariable int id) {
		return downloadResourceService.deleteDownloadResource(id);
	}
}
