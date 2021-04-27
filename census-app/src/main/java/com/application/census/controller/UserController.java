package com.application.census.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.application.census.entity.User;
import com.application.census.exception.UserException;
import com.application.census.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	//create user
	// http://localhost:8080/api/user/Register-user
	@PostMapping("/register-user")
	public ResponseEntity<User> RegisterUser(@RequestBody User user){
		try {
			User u=userService.RegisterUser(user);
			return new ResponseEntity<User>(u,HttpStatus.CREATED);
		} catch (UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	

	//find user by ID
	//http://localhost:8080/api/user/123412341234
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId){
		try {
			User u=userService.getUserById(userId);
			
			return new ResponseEntity<User>(u,HttpStatus.CREATED);
		} catch (UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	//Show User
	//http://localhost:8080/api/user/show-users
	@GetMapping("/show-users")
	public ResponseEntity<List<User>> getAllUser(){
		try {
			List<User> listusers=userService.getAllUsers();
			return new ResponseEntity<List<User>>(listusers,HttpStatus.CREATED);
		} catch (UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}




