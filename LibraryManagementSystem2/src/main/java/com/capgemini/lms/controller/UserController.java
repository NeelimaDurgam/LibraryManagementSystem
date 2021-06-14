package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.serviceimpl.Usersimpl;

@RestController
public class UserController {
	Usersimpl userImpl;
	@Autowired
	public UserController(Usersimpl userImpl) {
		this.userImpl = userImpl;
	}
	@GetMapping(value="/User",produces=MediaType.APPLICATION_JSON_VALUE)
	private List<Users> viewAllUsers(){
		return userImpl.viewAllUsers();
	}
	@GetMapping("/User/{id}")
	private List<Users> viewAllUsers(@PathVariable("id") int userid){
		return userImpl.viewAllUsers();
	}
	@DeleteMapping("/User/{id}")
	private int deleteUser(@PathVariable("id") int id) throws UserNotFoundException{
		return userImpl.deleteUser(id);
	}
	@PostMapping("/postUser")
	private int saveUser(@RequestBody Users user) throws UserNotFoundException {
		userImpl.register(user);
		return user.getUserid();
	}
	@PutMapping("/Userupdate")
	private int updateUserDetails(@RequestBody Users user) throws UserNotFoundException {
		userImpl.updateUserDetails(user);
		return 0;
	}
}
