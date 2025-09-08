package org.jsp.controller;

import org.jsp.entity.User;
import org.jsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@RequestBody User u){
		return service.saveUser(u);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id) {
		return service.findUserById(id);
	}	
	
	@GetMapping("/users/name/{name}")
	public ResponseEntity<?> findUserByName(@PathVariable String name){
		return service.findUserByName(name);	
	}
	@GetMapping("/users/email/{email}")
	public ResponseEntity<?> findUserByEamil(@PathVariable String email){
		return service.findUserByEmail(email);	
	}

}