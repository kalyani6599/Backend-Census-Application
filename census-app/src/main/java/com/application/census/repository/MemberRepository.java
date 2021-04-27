package com.application.census.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.census.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	List<Member> findByUserId(Long userId);

	Member findByAdharCardNo(Long adharCardNo);

	List<Member> findByGender(String gender);

	List<Member> findByCity(String city);

	List<Member> findByDistrict(String district);

	List<Member> findByPinCode(Integer pincode);

	List<Member> findByState(String state);

	List<Member> findByAgeBetween(Integer start, Integer end);

//	@Query("select m from Member m where m.userId=?1")
//	List<Member> findByUserId(Long userId);

}
