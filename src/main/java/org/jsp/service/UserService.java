package org.jsp.service;

import java.util.List;
import java.util.Optional;
import org.jsp.dao.UserDao;
import org.jsp.entity.User;
import org.jsp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public ResponseEntity<?> saveUser(User u) {
		User savedUser = dao.saveUser(u);
		ResponseStructure rs = new ResponseStructure(201, "User Saved Successfully", savedUser);		
		return ResponseEntity.status(201).body(rs);
	}

	public ResponseEntity<?> findUserById(int id) {
		Optional<User> optional = dao.findUserById(id);
		if (optional.isPresent()) {
			User u = optional.get();
			ResponseStructure rs = new ResponseStructure(200, "User Found Successfully", u);
			return ResponseEntity.status(200).body(rs);
		} else {			
			ResponseStructure rs = new ResponseStructure(404, "Invalid User Id, Unable to find User", "User Not Found");
			return ResponseEntity.status(200).body(rs);
		}
	}

	public ResponseEntity<?> findUserByName(String name) {
		List<User> ul=dao.findUserByName(name);
			ResponseStructure rs = new ResponseStructure(200, "All the users found with Name: "+name+" Found sucessfully...", ul);
			return ResponseEntity.status(200).body(rs);			
	}
	
	public ResponseEntity<?> findUserByEmail(String email) {
		   List<User> ul=dao.findUserByEmail(email);
			ResponseStructure rs = new ResponseStructure(200, "All the users found with Email: "+email+" Found sucessfully...", ul);
			return ResponseEntity.status(200).body(rs);	
		}
}
