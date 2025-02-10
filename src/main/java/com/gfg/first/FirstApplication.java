package com.gfg.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//how we can handle request
@SpringBootApplication
//i should setup tomcat server
//i should deploy my code to tomcat server
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

}
