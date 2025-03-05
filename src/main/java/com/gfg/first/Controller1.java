package com.gfg.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
@RequestMapping(value="/api")
// @Scope("request")
// @Scope("session")
public class Controller1 {
    
    // @Autowired
    // Student student;

    @Autowired
    User user;

    public Controller1(){
        System.out.println(" Controller1 Initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println(" contoller1 hashcode :"+this.hashCode()+" User hashcode :"+user.hashCode());
    }

    @GetMapping(path="/fetchUser")
    public ResponseEntity<String> getUserDetails(){
        System.out.println("fetch api invoked");
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    // @GetMapping(path = "/fetch")
    // public
}
