package com.example.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.userservice.model.User;
import com.example.userservice.exceptions.UserNotFoundException;

@Service
public class UserService {
	
	List<User> ul = new ArrayList<>();

	public UserService() {
		ul.add(new User(1,"Vihaan","Hyderabad "));
		ul.add(new User(2,"Veda Sri","Domakonda "));
		ul.add(new User(3,"Srikar","Dubbak "));
	}
	
	public List<User> getUsers(){		
		return ul;
	}
	
	public User getUserById(int uid) {
		return ul.stream().filter(u->u.getUid()==uid).findFirst().orElseThrow(()->new UserNotFoundException("User not found with : "+uid));
	}
	
	public User getUserByName(String uname) {
		return ul.stream().filter(u->u.getUname().equalsIgnoreCase(uname)).findFirst().orElseThrow(()->new UserNotFoundException("User not found with : "+uname));
	}
	
	public User insertUser(User usr) {
		
		ul.add(usr);
		
		return this.getUserById(usr.getUid());
	}
	
	public User updateUser(@PathVariable int uid,@RequestBody User usr) {
		
		User existingUsr = this.getUserById(uid);
		
		if(usr.getUname()!=null) {
			existingUsr.setUname(usr.getUname());
		}
		if(usr.getAddr()!=null) {
			existingUsr.setAddr(usr.getAddr());
		}
		
		return existingUsr;
	}
	
	public User deleteUser(@PathVariable int uid) {
		User existingUsr = this.getUserById(uid);
		ul.remove(existingUsr);
		return existingUsr;
	}
}
