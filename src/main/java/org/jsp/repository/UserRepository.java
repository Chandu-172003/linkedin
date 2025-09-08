package org.jsp.repository;

import java.util.List;

import org.jsp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

// Custom Query
//	@Query("Select u from User u where u.name=?1")
//	List<User> findUserByName(String name);     OR

	
	//Method Name Convention
	List<User> findByName(String name);

	//Method Name Convention
	List<User> findByEmail(String email);

}