package com.lgin.qb.phd.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lgin.qb.phd.Repository.FileRepository;
import com.lgin.qb.phd.model.FileModel;






@CrossOrigin(origins = "http://localhost:4200")
@RestController("/homes")
public class UploadFile {
	
	@Autowired
	FileRepository fileRepository;
	
 
    
    //  Upload file
     
    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
    	try {
    		// save file to PostgreSQL
	    	FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	    	fileRepository.save(filemode);
	    	return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (	Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}    
    }


}
