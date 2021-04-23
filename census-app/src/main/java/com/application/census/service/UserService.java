package com.application.census.service;

import java.util.List;

import com.application.census.entity.User;
import com.application.census.exception.UserException;

public interface UserService {
	
	public User RegisterUser(User user) throws UserException;
	
	public User getUserById(Long userId) throws UserException;
	
	public List<User> getAllUsers() throws UserException;

}
