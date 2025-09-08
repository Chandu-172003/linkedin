package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.User;
import org.jsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	UserRepository repository;

	public User saveUser(User u) {
		return repository.save(u);
	}
	

	public Optional<User> findUserById(int id) {
		return repository.findById(id);
	}


	public List<User> findUserByName(String name) {
		//return repository.findUserByName(name);   OR
		return repository.findByName(name);
	}

	public List<User> findUserByEmail(String email) {
		//return repository.findUserByEamil(email);   OR
		return repository.findByEmail(email);
	}

	

}