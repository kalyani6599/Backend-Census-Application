package com.application.census.service;

import java.util.List;

import com.application.census.entity.Member;
import com.application.census.exception.MemberException;

public interface MemberService {
	
	public Member addMember(Long userId, Member member) throws MemberException;
	
	public Member getMemberId(Long memberId) throws MemberException;
		
	public List<Member> getAllMembers() throws MemberException;
	
	public List<Member> getAllMembersbyUserId(Long UserId) throws MemberException;
	
	public Member updateMember(Member member) throws MemberException;
	
	public Integer deleteMemberById(Long memberId) throws MemberException;
	
	//Search Operation---------------
	
	public Member searchByAdharCardNo(Long adharCardNo) throws MemberException;
	public List<Member> searchByGender(String gender) throws MemberException;
	public List<Member> searchByCity(String city) throws MemberException;
	public List<Member> searchByDistrict(String district) throws MemberException;
	public List<Member> searchByPincode(Integer pinCode) throws MemberException;
	public List<Member> searchByState(String state) throws MemberException;
	public List<Member> searchBetweenAge(Integer start, Integer end) throws MemberException;

	

}
