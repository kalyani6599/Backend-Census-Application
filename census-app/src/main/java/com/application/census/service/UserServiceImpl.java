package com.application.census.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.application.census.entity.User;
import com.application.census.exception.UserException;
import com.application.census.repository.UserRepository;

@Service(value = "userService")

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User RegisterUser(User user) throws UserException {

		try {
			Optional<User> u=userRepository.findById(user.getUserId());
			if(u.isPresent())
			{throw new UserException("Email is already enrolled");
			}
			else {

				User user2=userRepository.save(user);
				return user2;
			}

		} catch (DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public User getUserById(Long userId) throws UserException {
		Optional<User> u=userRepository.findById(userId);
		if(u.isPresent()) {
			return u.get();
		}
		else
		{
			throw new UserException("Record not found");
		}

	}

	@Override
	public List<User> getAllUsers() throws UserException {
		List<User> listusers=userRepository.findAll();
		if(!(listusers==null)) {
			return listusers;
		}
		else
		{
			throw new UserException("Record not found");
		}

	}

}
