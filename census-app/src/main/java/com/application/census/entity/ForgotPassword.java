package com.application.census.entity;

import lombok.Data;

@Data
public class ForgotPassword {
	private Long userId;
	private String emailId;
	private String newPassword;
}
