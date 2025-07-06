package com.example.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.User;

@RestController
public class UserController {
	
	@RequestMapping("/greet")
	public String greet() {
		return "Hello there!";
	}
	
	@RequestMapping("/user")
	public User getUser() {
		return new User(1,"Srikar","Dubbak");
	}
	
	@RequestMapping("/users")
	public List<User> getUsers(){
		List<User> ul = new ArrayList<>();
		ul.add(new User(1,"Vihaan","Hyderabad"));
		ul.add(new User(2,"Veda","Domakonda"));
		ul.add(new User(3,"Srikar","Dubbak"));
		
		return ul;
	}
	
}
