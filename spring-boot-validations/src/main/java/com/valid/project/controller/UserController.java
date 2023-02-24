package com.valid.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valid.project.dto.UserRequest;
import com.valid.project.entity.User;
import com.valid.project.exception.UserNotFoundException;
import com.valid.project.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	public ResponseEntity<User> save(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(service.save(userRequest),HttpStatus.CREATED);	
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return ResponseEntity.ok(service.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(service.getUser(id));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		System.out.println("here");
		return ResponseEntity.ok(service.getByEmail(email));
	}
}
