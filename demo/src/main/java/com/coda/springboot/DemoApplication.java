package com.coda.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.coda.springboot.models.user;
import com.coda.springboot.repository.userrepository;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    private static userrepository repository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		mongo_get();
//	}
//	public static void mongo_get() {
//		user u = repository.findUserByName("munish").get(0);
//		if(u!=null) {
//		System.out.print(u.password);
//		}
	}
}
