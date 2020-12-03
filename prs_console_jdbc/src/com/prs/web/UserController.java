package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import prs.business.User;

//CRUD
public interface UserController {
	
	@Autowired       // Wires database to your controller
	private User User;
	
	//login via POST
	@PostMapping("/login")
	public Optional<User> login(@RequestBody User u) {
		Optional<User> u = userRepo.findByUserNameAndPassword(userName, password);
		if (user.isPresent()) {
			return user;
		} else {
			throw new ResponseStatusException(HttpStatus.Not_Found, "User not Found");
		}
		
	}
/* POSTMAN:  http://localhost:8080/users/login?userName=DarkEyestheBaker&passoword=Br0wni3s 
 * Key 1 user 
 * Key 2 password
 * DON'T DO IN GET - DO IN POST!!
 * USER REPO:  Optional<User> findByUserNameAndPassword(String userName, password);  
 * 
 * */
	
}
