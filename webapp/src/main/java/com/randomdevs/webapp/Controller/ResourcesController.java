package com.randomdevs.webapp.Controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.randomdevs.webapp.Entity.ResourcesEntity;
import com.randomdevs.webapp.Service.ResourcesService;

@RestController
@RequestMapping("/resources")
public class ResourcesController {
	@Autowired
    private ResourcesService resserv;
	
    @PostMapping("/putResources")
    public ResourcesEntity putResources(@RequestParam String r_title, @RequestParam String r_description, 
    		@RequestParam("file") MultipartFile file) 
    		throws IOException {
    				ResourcesEntity rEntity = resserv.postResources(r_title, r_description, file);
    				return rEntity;
    }
    
    @GetMapping("/getResourcesById/{r_id}")
	public ResourcesEntity getResources(@PathVariable int r_id) throws IOException{
		return resserv.getResources(r_id);
	} 
    
    @GetMapping("/getAllResources")
    public List<ResourcesEntity> getAllResources(){
    	return resserv.getAllResources();
    }
    
    @PutMapping("/putResources")
    public ResourcesEntity putResources(@RequestParam int r_id, @RequestBody ResourcesEntity res) throws Exception{
    	return resserv.putResources(r_id, res);
    }
    
    @DeleteMapping("/deleteResources/{r_id}")
    public String deleteResources(@PathVariable int r_id) throws Exception {
		return resserv.deleteResources(r_id);
	}
}
