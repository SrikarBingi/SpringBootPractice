package com.gfg.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("prototype")
public class Student {
    @Autowired
    User user;

    public Student(){
        System.out.println("Student Initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("Student hashcode :"+this.hashCode());
    }
}
