package com.application.census.service;

import java.time.LocalDate;
import java.time.Period;
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
			member.setUserId(u.getUserId());

			LocalDate dob= member.getDob();
			LocalDate currentDate = LocalDate.now();
			member.setAge(Period.between(dob,currentDate).getYears());
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
	public List<Member> getAllMembersbyUserId(Long userId) throws MemberException {
		List<Member> memList=null;
		try {
			Optional<User> uOptional=userRepository.findById(userId);
			User u=null;
			if(uOptional.isPresent()) {

				memList=memberRepository.findByUserId(userId);


			}	

		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
		return memList;
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
	public Integer deleteMemberById(Long memberId) throws MemberException {
		try {

			memberRepository.deleteById(memberId);
			return 1;
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public Member searchByAdharCardNo(Long adharCardNo) throws MemberException {
		try {
			return memberRepository.findByAdharCardNo(adharCardNo);
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public List<Member> searchByGender(String gender) throws MemberException {
		try {
			return memberRepository.findByGender(gender);
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public List<Member> searchByCity(String city) throws MemberException {
		try {
			return memberRepository.findByCity(city);
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public List<Member> searchByDistrict(String district) throws MemberException {
		try {
			return memberRepository.findByDistrict(district);
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public List<Member> searchByPincode(Integer pinCode) throws MemberException {
		try {
			return memberRepository.findByPinCode(pinCode);
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}


	@Override
	public List<Member> searchByState(String state) throws MemberException {
		try {
			return memberRepository.findByState(state);
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}

	@Override
	public List<Member> searchBetweenAge(Integer start,Integer end) throws MemberException {
		try {
			return memberRepository.findByAgeBetween(start,end);
		} catch (DataAccessException e) {
			throw new MemberException(e.getMessage(),e);
		}
	}

}
