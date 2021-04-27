package com.application.census.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.application.census.entity.Member;
import com.application.census.exception.MemberException;
import com.application.census.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/member")
@Slf4j
@CrossOrigin("*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//create-member
	// http://localhost:8080/api/member/add-member/123123123123
	@PostMapping("/add-member/{userId}")
	public ResponseEntity<Member> addMember(@PathVariable Long userId, @RequestBody Member member){
		try {
			Member mem=memberService.addMember(userId, member);
			return new ResponseEntity<Member>(mem,HttpStatus.CREATED);
		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
