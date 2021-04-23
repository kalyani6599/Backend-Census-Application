package com.application.census.service;

import com.application.census.entity.ForgotPassword;
import com.application.census.entity.Login;
import com.application.census.entity.Logout;
import com.application.census.exception.UserException;

/**
 * The Interface LoginService.
 */
public interface LoginService {

	/**
	 * Sign in.
	 *
	 * @param registerUser the register user
	 * @return the string
	 */
	public String signIn(Login login) throws UserException;
	
	/**
	 * Sign out.
	 *
	 * @param registerUser the register user
	 * @return the string
	 */
	public String signOut(Logout registerUser) throws UserException;
	
	/**
	 * Change password.
	 *
	 * @param registerUser the register user
	 * @param new_password the new password
	 * @return the string
	 */
//	public String changePassword(Login registerUser, String );
	
	public String forgotPassword(ForgotPassword registerUser) throws UserException;

}