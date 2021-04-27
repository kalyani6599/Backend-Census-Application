package com.application.census.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.application.census.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
