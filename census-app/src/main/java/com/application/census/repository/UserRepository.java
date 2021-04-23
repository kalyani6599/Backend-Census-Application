package com.application.census.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.census.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
