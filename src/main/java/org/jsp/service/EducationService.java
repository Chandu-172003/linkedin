package org.jsp.service;

import java.util.List;
import java.util.Optional;
import org.jsp.dao.EducationDao;
import org.jsp.dao.UserDao;
import org.jsp.entity.Education;
import org.jsp.entity.User;
import org.jsp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
	
	@Autowired
	EducationDao educationDao;
	
	@Autowired
	UserDao userDao;
	public ResponseEntity<?> saveEducation(Education e, int uid) {
	    Optional<User> optional = userDao.findUserById(uid);
	    if (optional.isPresent()) {
	        User u = optional.get();
	        e.setUser(u);
	        Education savedEducation = educationDao.saveEducation(e);
	        ResponseStructure rs = new ResponseStructure(201, "Education Saved Successfully for " + u.getName(), savedEducation);
	        return ResponseEntity.status(201).body(rs);
	    } else {
	        ResponseStructure rs = new ResponseStructure(400, "Invalid User ID, Unable to save education", "Education Not Saved");
	        return ResponseEntity.status(400).body(rs);
	    }
	}
	
	public ResponseEntity<?> findAllEducations() {
		List<Education> el = educationDao.findAllEducations();
		ResponseStructure rs = new ResponseStructure(200, "All Educatons Found Successfully", el);	
		return ResponseEntity.status(200).body(rs);
	}
	
	public ResponseEntity<?> findAllEducationsByUserId(int uid) {
		List<Education> el = educationDao.findAllEducationByUserId(uid);
		ResponseStructure rs = new ResponseStructure(200, "All Educations of The User Found Successfully", el);
		return ResponseEntity.status(200).body(rs);
	}

	public ResponseEntity<?> findAllEducationByEducationId(int eid) {
		List<Education> le= educationDao.findAllEducationByEducationId(eid);
		ResponseStructure rs = new ResponseStructure(201, "All Eduction Found By Education Id", le);		
		return ResponseEntity.status(201).body(rs);
	}

	public ResponseEntity<?> deleteEducationByEducationId(int eid) {
		Optional<Education> oe=educationDao.deleteEductionByEductionId(eid);		
		if(oe.isPresent()) {
			Education ee= oe.get();
		ResponseStructure rs= new ResponseStructure(200, "Education deleted successfully.", ee);
		return ResponseEntity.status(200).body(rs);
		}else {
		ResponseStructure rs= new ResponseStructure(404, "Education Not Found to delete.", oe);
		return ResponseEntity.status(404).body(rs);
	}
	}
	public ResponseEntity<?> findEducationsByUniversity(String unviersity) {
		List<Education> le=educationDao.findEducationByUniversity(unviersity);
		ResponseStructure rs= new ResponseStructure(200,"Education found by university succesfully", le);
		return ResponseEntity.status(404).body(rs);
	}

	public ResponseEntity<?> deleteEducationByYOP(int yop) {
		Optional<Education> oe= educationDao.deleteEductionByYOP(yop);
		if(oe.isPresent()) {
			Education ee=oe.get();
			ResponseStructure rs= new ResponseStructure(200,"Education By YOP delete successfully", ee);
			return ResponseEntity.status(404).body(rs);
		}else {
			ResponseStructure rs = new ResponseStructure(404,"Education By YOP is Not found", oe);
			return ResponseEntity.status(404).body(rs);	
		}
	}

	public ResponseEntity<?> findUserEducationSummary(int uid) {
		Optional<Education> oe=educationDao.findUserEducationSummary(uid);
		
		
		
		
		
		
		
		
		return null;
	}

}
	

