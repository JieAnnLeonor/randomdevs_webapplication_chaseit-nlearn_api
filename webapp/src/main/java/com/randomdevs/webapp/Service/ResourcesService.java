package com.randomdevs.webapp.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.randomdevs.webapp.Entity.ResourcesEntity;
import com.randomdevs.webapp.Entity.TeacherEntity;
import com.randomdevs.webapp.Repository.ResourcesRepository;
import com.randomdevs.webapp.Repository.TeacherRepository;

@Service
public class ResourcesService {
	@Autowired
    private ResourcesRepository resrep;
	@Autowired
	private TeacherRepository teachrep;
	//post
    public ResourcesEntity postResources(String r_title, String r_description, MultipartFile file) throws IOException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            ResourcesEntity rEntity = new ResourcesEntity();//(fileName, file.getContentType(), file.getBytes());
            rEntity.setR_data(file.getBytes());
            rEntity.setR_description(r_description);
            rEntity.setR_name(fileName);
            rEntity.setR_title(r_title);
            rEntity.setR_type(file.getContentType());
            return resrep.save(rEntity);
        } catch (IOException ex) {
            throw new IOException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    
    //get
    public ResourcesEntity getResources(int r_id) throws IOException {
        return resrep.findById(r_id).orElseThrow(() -> new IOException("File not found with id " + r_id));
    }
    
    //get
    public List<ResourcesEntity> getAllResources(){
    	return resrep.findAll();
    }
    
    //put
    public ResourcesEntity putResources(int r_id, ResourcesEntity resource) throws Exception {
    		ResourcesEntity res = new ResourcesEntity();
		
		try {
			res = resrep.findById(r_id).get();
			
			//Step 2 - update the record
			res.setR_description(resource.getR_description());
			res.setR_title(resource.getR_title());
			
			//Step 3 - save the information and return the value --refer to finally block
			return resrep.save(res);
			
		}catch(NoSuchElementException id) {
			throw new Exception("ID Number " + id + " does not exist!");
		}
    }
    
    //put
    public ResourcesEntity assignTeacher(int res_id, int teach_id) throws Exception{
    	ResourcesEntity res = new ResourcesEntity();
    	TeacherEntity teach = new TeacherEntity();
    	try {
			//steps in updating
			//1 - search the id number of the teacher
			res = resrep.findById(res_id).get(); //findById is a pre-defined method
			if(res.getTeacher()!=null)
				throw new Exception("Teacher assigned");
			else {
			teach = teachrep.findById(teach_id).get();
			//2 - if found then update the record
			res.setTeacher(teach);
			//3 - save the information and return the value -- refer to finally block
			return resrep.save(res);
			}
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + res_id + " does not exist");
		}
    }
    
    //delete
    public String deleteResources(int id) throws Exception{
    	String msg;
    	if(resrep.findById(id)!=null) {
			resrep.deleteById(id);
			msg = "Resources with ID Number " + id + " is successfully deleted";
		}else {
			msg = "Resources with ID Number " + id + " is NOT found!";
		}
		return msg;
    }
}
