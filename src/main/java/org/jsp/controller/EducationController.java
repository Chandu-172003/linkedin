package org.jsp.controller;

import org.jsp.entity.Education;
import org.jsp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationController {
	
	@Autowired
	EducationService service;
	
    @PostMapping("/educations/{uid}")
    public ResponseEntity<?> saveEducation(@RequestBody Education e, @PathVariable int uid) {
	return service.saveEducation(e, uid);
    }
	
	@GetMapping("/educations")
	public ResponseEntity<?> findAllEducations(){
		return service.findAllEducations();
	}
	
	@GetMapping("/educations/{uid}")
	public ResponseEntity<?> findAllEducationsByUserId(@PathVariable int uid){
		return service.findAllEducationsByUserId(uid);
	}
	
	@GetMapping("/education/{eid}")
	public ResponseEntity<?> findAllEducationByEducationId(@PathVariable int eid){
		return service.findAllEducationByEducationId(eid);	
	}
	
	@DeleteMapping("/eduction/{eid}")
	public ResponseEntity<?> deleteEducationByEducationId(@PathVariable int eid){
		return service.deleteEducationByEducationId(eid);	
	}
	
	@GetMapping("education/university/{university}")
	public ResponseEntity<?> findEducationsByUniversity(@PathVariable String unviersity){
		return service.findEducationsByUniversity(unviersity);
	}
	
    @DeleteMapping("/education/YOP/{yop}")
    public ResponseEntity<?> deleteEducationByYOP(@PathVariable int yop){
    	return service.deleteEducationByYOP(yop);
    }
    
    @GetMapping("/education/summary/{summary}")
    public ResponseEntity<?> findUserEducationSummary(@PathVariable int uid){
    	return service.findUserEducationSummary(uid);
    }
    
	//findEducationsByCGPAGreaterThan(double minCgpa)
	//updateCGPAByEducationId(int eid, double newCgpa)
	//getUsersWithCGPAMoreThan(double minCgpa)
	
	//getUserEducationSummary(int uid)
	//getTopEducatedUsersByCGPA()
	//checkIfUserHasCompleted(String qualification, int uid)
}
