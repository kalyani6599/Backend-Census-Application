package com.application.census.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user_info")
public class User {

	//User id (AdharCard Number)
	@Id
	@Column(name = "userId")
	private Long userId;
	
	@NotNull
	@Email(message="Email format invalid!")
	@Column(name = "emailId")
	private String emailId;
	
//	@Size(max=10)
	@Column(name="mobileNo", nullable = false)
	private Long mobile;
	
	@Column(name = "role")
	private String role;
	
	@NotNull
	//@Pattern(regexp="^[A-Za-z_0-9@#$%]{6,12}",message="Password must be 6 characters")
	@Column(name="password")
	private String password;
	
	
}



	
	
//	@NotNull
//	@Pattern(regexp="^[A-Za-z_0-9@#$%]{6,12}",message="password and Re entered password must be same")
//	@Column(name="reEnterpassword")
//	private String ReEnterPassword;
//	
//	@OneToMany(mappedBy = "user")
//	@JsonIgnore
//	private List<Player> players;
//}
