package com.application.census.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.census.entity.ForgotPassword;
import com.application.census.entity.Login;
import com.application.census.entity.Logout;
import com.application.census.entity.User;
import com.application.census.exception.UserException;
import com.application.census.repository.LoginRepository;

import java.util.Optional;
/**
 * The Class LoginServiceImpl.
 */
@Service(value = "loginService")

public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public String signIn(Login login) throws UserException {
		String str = null;
		Optional<User> userObj = loginRepository.findById(login.getUserId());
		if (!userObj.isPresent()) {
			System.out.println(userObj);
			throw new UserException("user not found for this id");
		} else {
			String pwd = userObj.get().getPassword();
 			if (!pwd.equals(login.getPassword())) {
				throw new UserException("WRONG_PASSWORD");
			}
			try {
				str = "Sign in sucessfull";
				loginRepository.saveAndFlush(userObj.get());
			} catch (Exception e) {
				throw new UserException("OPERATION_FAILED");
			}
		}
		return str;
	}

	@Override
	public String signOut(Logout registerUser) throws UserException {
		String str = null;
		Optional<User> userObj = loginRepository.findById(registerUser.getUserId());
		if (!userObj.isPresent()) {
			throw new UserException("USER_NOT_FOUND");
		} else {
			try {
				str = "Sign Out sucessfull";
				loginRepository.saveAndFlush(userObj.get());
			} catch (Exception e) {
				throw new UserException("OPERATION_FAILED");
			}
		}
		return str;
	}

	@Override
	public String forgotPassword(ForgotPassword registerUser) throws UserException {
		String str = null;
		Optional<User> userObj = loginRepository.findById(registerUser.getUserId());
		
		if (!userObj.isPresent()) {
			throw new UserException("USER_NOT_FOUND");
		} else {
			Long userId = userObj.get().getUserId();
			if (!userId.equals(registerUser.getUserId())) {
				throw new UserException("USER_NOT_FOUND");
			}
			try {
				userObj.get().setPassword(registerUser.getNewPassword());
				loginRepository.saveAndFlush(userObj.get());
				str = "Password updated sucessfully";
			} catch (Exception e) {
				throw new UserException("OPERATION_FAILED");
			}
		}
		return str;
	}

}


/*
 * @Override public String changePassword(Login registerUser, String
 * new_password) { String str = null; Optional<User> userObj =
 * loginRepository.findByEmailId(registerUser.getEmailId()); if
 * (!userObj.isPresent()) { throw new ResourceNotFound("USER_NOT_FOUND"); } else
 * { String pwd = userObj.get().getPassword(); if
 * (!pwd.equals(registerUser.getPassword())) { throw new
 * ResourceNotFound("WRONG_PASSWORD"); } try {
 * userObj.get().setPassword(new_password);
 * loginRepository.saveAndFlush(userObj.get()); str =
 * "Password changed sucessfully"; } catch (Exception e) { throw new
 * ResourceNotFound("OPERATION_FAILED"); } } return str; }
 */