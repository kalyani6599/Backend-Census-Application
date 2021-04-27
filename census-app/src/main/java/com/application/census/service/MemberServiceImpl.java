package com.application.census.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.application.census.entity.Member;
import com.application.census.entity.User;
import com.application.census.exception.MemberException;
import com.application.census.repository.MemberRepository;
import com.application.census.repository.UserRepository;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public Member addMember(Long userId, Member member) throws MemberException {
		
		try {
			Optional<User> uOptional=userRepository.findById(userId);
			User u=null;
			if(uOptional.isPresent()) {
				u=uOptional.get();
			}	
			member.setUser(u);
			return memberRepository.save(member);


		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public Member getMemberId(Long memberId) throws MemberException {
		try {
			Optional<Member> opt=memberRepository.findById(memberId);
			if(opt.isPresent()) {
				return opt.get();
			}
			else 
				throw new MemberException("unable to find id");
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public List<Member> getAllMembers() throws MemberException {
		try {
			return memberRepository.findAll();
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public List<Member> getAllMembersbyUserId(Long UserId) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Member updateMember(Member member) throws MemberException {
		try {
			Member p=memberRepository.getOne(member.getMemberId());
			if(p!=null) {
				Member p3=memberRepository.save(member);
				return p3;
			}else {
				throw new MemberException("No record found for given id");
			}

		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public Integer deleteMember(Long memberId) throws MemberException {
		try {

			memberRepository.deleteById(memberId);
			return 1;
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}

}
