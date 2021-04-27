package com.application.census.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

	
	private Long userId;
	private String password;
	private String role;
	
	
	
}
