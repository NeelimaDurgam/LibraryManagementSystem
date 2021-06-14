package com.capgemini.lms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.service.UserService;
import com.capgemini.lms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Usersimpl implements UserService{
	@Autowired
	UsersRepository userRepository;

	@Override
	public Users register(Users user) {
			userRepository.save(user);
		return user;
	}

	@Override
	public Users loginValidate(String username, String password) throws UserNotFoundException {
		try {
			userRepository.save(new Users());
		}catch(Exception e) {
			throw new UserNotFoundException("The passed object cannot be null");
		}
		return null;
	}

	public void cancelSubscription(int userid) throws UserNotFoundException {
		try {
			userRepository.deleteById(userid);
		} catch (Exception e) {
			throw new UserNotFoundException("The object cannot be null");
		}
	}

	@Override
	public void payThePenalty(int userid, double amount) throws UserNotFoundException {
		try {
			userRepository.save(new Users());
		}catch(Exception e) {
			throw new UserNotFoundException("The passed object cannot be null");
		}
	}

	@Override
	public List<Users> viewAllUsers() {
		List<Users> result = new ArrayList<Users>();
        userRepository.findAll().forEach(User1 -> result.add(User1));
		return result;
	}

	@Override
	public int updateUserDetails(Users user) throws UserNotFoundException {
		try {
			userRepository.save(user);
		}catch(Exception e) {
			throw new UserNotFoundException("The passed object cannot be null");
		}
		return 0;
	}

	@Override
	public int deleteUser(int id) throws UserNotFoundException {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			throw new UserNotFoundException("The object cannot be null");
		}
		return id;
	}

}
