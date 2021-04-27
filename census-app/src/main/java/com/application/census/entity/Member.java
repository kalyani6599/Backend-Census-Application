package com.application.census.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="member_info")
public class Member {
	
	@Id
	@Column(name = "memberId")
	private Long memberId;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "motherName")
	private String motherName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "mobileNo")
	private Long mobileNo;
	
	@Column(name = "adharCardNo")
	private Long adharCardNo;
	
	@Column(name = "voterIdNo")
	private String voterIdNo;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "educationDetails")
	private String educationDetails;
	
	@Column(name = "marritalStatus")
	private String marritalStatus;
	
	@Column(name = "relationship")
	private String relationship;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pinCode")
	private Integer pinCode;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "userId")
	private Long userId;
	
	
//	@ManyToOne
//	@JoinColumn(name="userId")
//	private User user;
	
}
