package com.application.census.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.census.entity.User;

public interface LoginRepository extends JpaRepository<User, Long>{
	
	

}
