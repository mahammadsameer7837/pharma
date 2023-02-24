package com.valid.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.valid.project.dto.UserRequest;
import com.valid.project.entity.User;
import com.valid.project.exception.UserNotFoundException;
import com.valid.project.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Serivcetwo sert;
	
	public User save(UserRequest userRequest) {
		sert.run();
		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setAge(userRequest.getAge());
		user.setGender(userRequest.getGender());
		user.setMobile(userRequest.getMobile());
		user.setNationality(userRequest.getNationality());
		return userRepository.save(user);
		
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(int id) throws UserNotFoundException {
		 User user=  userRepository.findByUserId(id); //.orElseThrow(() -> new IllegalArgumentException("Id not found"));
		 if(user != null) {
			 return user;
		 }
		 else {
			 throw new UserNotFoundException("User with "+id+" not found");
		 }
	
	}
	
	public User getByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if(user==null) {
			System.out.println("hey he is nit here");
		}
		return user;
	}
	
	

}
