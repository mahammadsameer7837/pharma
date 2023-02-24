package com.valid.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valid.project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	 User findByUserId(int id);

	User findByEmail(String email);

}
