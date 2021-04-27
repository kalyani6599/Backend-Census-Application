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
	
	public Integer deleteMember(Long memberId) throws MemberException;
	
	//Search Operation---------------

}
