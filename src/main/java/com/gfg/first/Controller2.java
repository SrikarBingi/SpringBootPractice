package com.gfg.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// @RestController
@RequestMapping(value="/api")
public class Controller2 {

    // @Autowired
    User user;

    public Controller2(){
        System.out.println("Controller2 Initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("contoller2 hashcode :"+this.hashCode()+" User hashcode :"+user.hashCode());
    }
}
