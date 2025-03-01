package com.gfg.first;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

import jakarta.annotation.PostConstruct;

@Component
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
    public User(){
        System.out.println(" User intialized");
    }
    @PostConstruct
    public void init(){
        System.out.println("User hashcode :"+this.hashCode());
    }
}
