package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.UserNotFoundException;

public interface UserService {
	public Users register(Users user);
	public Users loginValidate(String username,String password) throws UserNotFoundException;
	public void cancelSubscription(int userid) throws UserNotFoundException;
	public void payThePenalty(int userid, double amount) throws UserNotFoundException;
	public List<Users> viewAllUsers();
	public int updateUserDetails(Users user) throws UserNotFoundException;
	public int deleteUser(int id) throws UserNotFoundException;
}
