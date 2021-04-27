package com.application.census.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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



	//getAllMembers
	//localhost:8080/api/member/memberInfo
	@GetMapping("/memberInfo")
	public ResponseEntity<List<Member>> getAllMembers(){
		try {
			List<Member> memList=memberService.getAllMembers();
			return new ResponseEntity<>(memList,HttpStatus.OK);
		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}


	//delete by id
	//localhost:8080/api/member/delete/1
	@DeleteMapping("delete/{memberId}")
	public String deleteMemberById(@PathVariable( value = "memberId") Long memberId){
		try {
			Integer status=memberService.deleteMemberById(memberId);
			if(status==1)
				return "player "+ memberId +" deleted from database";
			else
				return "Unable to delete";
		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//update player
	//localhost:8080/api/member/update/1
	@PutMapping("update/{memberId}")
	public ResponseEntity<Member> updateMemberInfo(@PathVariable( value = "memberId") Long memberId,@RequestBody Member member){
		Member mem;
		try {
			mem=memberService.getMemberId(memberId);

			mem.setFullName(member.getFullName());
			mem.setMotherName(member.getMotherName());
			mem.setDob(member.getDob());
			mem.setAge(member.getAge());
			mem.setGender(member.getGender());
			mem.setMobileNo(member.getMobileNo());
			mem.setAdharCardNo(member.getAdharCardNo());
			mem.setVoterIdNo(member.getVoterIdNo());
			mem.setNationality(member.getNationality());
			mem.setEducationDetails(member.getEducationDetails());
			mem.setMarritalStatus(member.getMarritalStatus());
			mem.setRelationship(member.getRelationship());
			mem.setCity(member.getCity());
			mem.setPinCode(member.getPinCode());
			mem.setDistrict(member.getDistrict());
			mem.setState(member.getState());



			return new ResponseEntity<Member>(memberService.updateMember(mem),HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//serach by id
	//localhost:8080/api/member/searchById/123412341234
	@GetMapping("/searchById/{memberId}")
	public ResponseEntity<Member> getById(@PathVariable Long memberId){
		try {
			Member mem=memberService.getMemberId(memberId);
			return new ResponseEntity<>(mem,HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}


	//getAllMembers by USERID
	//localhost:8080/api/member/memberByUserId/123412341234
	@GetMapping("/memberByUserId/{userId}")
	public ResponseEntity<List<Member>> getAllMembersByUserId(@PathVariable ( value = "userId") Long userId){
		try {

			List<Member> memList=memberService.getAllMembersbyUserId(userId);
			return new ResponseEntity<>(memList,HttpStatus.OK);
		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}


	//search by Adhar Card No name
	//localhost:8080/api/member/searchByAdharCard/123412341234
	@GetMapping("/searchByAdharCard/{adharCardNo}")
	public ResponseEntity<Member> searchMemberByAdharCardNo(@PathVariable Long adharCardNo){
		try {
			Member m=memberService.searchByAdharCardNo(adharCardNo);
			return new ResponseEntity<>(m,HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}


	//search by Gender
	//localhost:8080/api/member/searchByGender/Female
	@GetMapping("/searchByGender/{gender}")
	public ResponseEntity<List<Member>> searchMembersByGender(@PathVariable String gender){
		try {
			List<Member> memList=memberService.searchByGender(gender);
			return new ResponseEntity<>(memList,HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}


	//search by city
	//localhost:8080/api/member/searchByCity/Vita
	@GetMapping("/searchByCity/{city}")
	public ResponseEntity<List<Member>> searchMembersByCity(@PathVariable String city){
		try {
			List<Member> memList=memberService.searchByCity(city);
			return new ResponseEntity<>(memList,HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}


	//search by district
	//localhost:8080/api/member/searchByDistrict/Sangli
	@GetMapping("/searchByDistrict/{district}")
	public ResponseEntity<List<Member>> searchMembersByDistrict(@PathVariable String district){
		try {
			List<Member> memList=memberService.searchByDistrict(district);
			return new ResponseEntity<>(memList,HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//search by state
	//localhost:8080/api/member/searchByState/MH
	@GetMapping("/searchByState/{state}")
	public ResponseEntity<List<Member>> searchMembersByState(@PathVariable String state){
		try {
			List<Member> memList=memberService.searchByState(state);
			return new ResponseEntity<>(memList,HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//search by pincode
	//localhost:8080/api/member/searchByPincode/415311
	@GetMapping("/searchByPincode/{pinCode}")
	public ResponseEntity<List<Member>> searchMembersByPinCode(@PathVariable Integer pinCode){
		try {
			List<Member> memList=memberService.searchByPincode(pinCode);
			return new ResponseEntity<>(memList,HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//search between 2 ages
	//localhost:8080/api/member/searchBetweenAges
	@GetMapping("/searchBetweenAges/{start}/{end}")
	public ResponseEntity<List<Member>> searchMembersByPinCode(@PathVariable Integer start,@PathVariable  Integer end){
		try {
			List<Member> memList=memberService.searchBetweenAge(start,end);
			return new ResponseEntity<>(memList,HttpStatus.OK);

		} catch (MemberException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
