package com.application.census.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

	@Id
	@Column( name = "userId")
	private Long userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	
	
}
