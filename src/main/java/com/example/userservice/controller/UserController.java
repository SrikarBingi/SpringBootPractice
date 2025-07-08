package com.example.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.User;
import com.example.userservice.service.UserService;

//import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
//	@RequestMapping("/greet")
	@GetMapping("/greet")
	public String greet() {
		return "Hello there!";
	}
	
//	@RequestMapping("/users")
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
//		List<User> ul = new ArrayList<>();
//		ul.add(new User(1,"Vihaan","Hyderabad"));
//		ul.add(new User(2,"Veda Sri","Domakonda"));
//		ul.add(new User(3,"Srikar","Dubbak"));
//		
//		return ul;
		
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
	}
	
//	@RequestMapping("/users")
//	public User getUser() {
//		return new User(1,"Srikar","Dubbak");
//	}
	
//	@RequestMapping("/user/{uid}")
	@GetMapping("/user/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable int uid) {
//		return ul.stream().filter(u->u.getUid()==uid).findFirst().orElseThrow(()->new RuntimeException("User not found with : "+uid));
//		return service.getUserById(uid);
		return new ResponseEntity<User>(service.getUserById(uid), HttpStatus.OK);
	}
	
	@RequestMapping("/username")
	public ResponseEntity<User> getUserByName(@RequestParam String uname) {
//		return ul.stream().filter(u->u.getUname().equalsIgnoreCase(uname)).findFirst().orElseThrow(()->new RuntimeException("User not found with : "+uname));
//		return service.getUserByName(uname);
		return new ResponseEntity<User>(service.getUserByName(uname), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public ResponseEntity<User> insertUser(@RequestBody User usr) {
		
//		ul.add(usr);
		
//		return ul.stream().filter(u->u.getUid()==usr.getUid()).findFirst().orElseThrow(()->new RuntimeException("Unable to save user "));
		return  new ResponseEntity<User>(service.insertUser(usr),HttpStatus.CREATED);
	}
	
	
//	@RequestMapping(value = "/update/{uid}", method = RequestMethod.PUT)
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable int uid,@RequestBody User usr) {
		
//		User existingUsr = ul.stream().filter(u->u.getUid()==uid).findFirst().orElseThrow(()->new RuntimeException("User not found with : "+uid));
//		
//		if(usr.getUname()!=null) {
//			existingUsr.setUname(usr.getUname());
//		}
//		if(usr.getAddr()!=null) {
//			existingUsr.setAddr(usr.getAddr());
//		}
//		
		return  new ResponseEntity<User>(service.updateUser(uid,usr),HttpStatus.CREATED);
	}
	
//	@RequestMapping(value = "/delete/{uid}", method = RequestMethod.DELETE)
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<User> deleteUser(@PathVariable int uid) {
//		User existingUsr = ul.stream().filter(u->u.getUid()==uid).findFirst().orElseThrow(()->new RuntimeException("User not found with : "+uid));
//		
//		ul.remove(existingUsr);
//		return existingUsr;
		return new ResponseEntity<User>(service.deleteUser(uid),HttpStatus.ACCEPTED);
	}
}
