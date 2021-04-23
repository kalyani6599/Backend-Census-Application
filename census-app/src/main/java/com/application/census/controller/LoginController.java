package com.application.census.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.census.entity.ForgotPassword;
import com.application.census.entity.Login;
import com.application.census.entity.Logout;
import com.application.census.exception.UserException;
import com.application.census.service.LoginService;


/**
 * The Class LoginController.
 */
@RestController
@RequestMapping("/api/process")
@CrossOrigin("http://localhost:3000")

public class LoginController {

	@Autowired 
	private LoginService loginService;

	//http://localhost:8080/api/process/login
	
	@PostMapping("/login")
	public ResponseEntity<?> signIn( @RequestBody Login login) throws UserException {
		String str = loginService.signIn(login);
		
		return new ResponseEntity<>(str, HttpStatus.OK);
	}

	//http://localhost:8080/api/process/logout
	@PostMapping("/logout") 

	public ResponseEntity<?> signOut( @RequestBody Logout registerUser) throws UserException {
		String str = loginService.signOut(registerUser);
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	

	
	//http://localhost:8080/api/process/forget-password
	@PostMapping("/forget-password")
	public ResponseEntity<?> forgotPassword( @RequestBody ForgotPassword registerUser) throws UserException {
		String str =loginService.forgotPassword(registerUser);
		return new ResponseEntity<>(str, HttpStatus.OK);
	}

}

/*
 * http://localhost:8080/api/Login/reset/newPass
 * 
 * @PostMapping("/reset/{new_password}") public ResponseEntity<?>
 * changePassword( @RequestBody Login registerUser, @PathVariable String
 * new_password) { String str =loginService.changePassword(registerUser,
 * new_password);
 * 
 * return new ResponseEntity<>(str, HttpStatus.OK); }
 */