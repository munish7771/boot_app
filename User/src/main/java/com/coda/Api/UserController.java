package com.coda.Api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coda.Bean.User;
import com.coda.Service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value={"/users"})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;
    
    @Autowired
    RestTemplate restTemplate = new RestTemplate();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers(){
    	log.info("In API.getAllUsers");
    	return (userService.getUsers());
    }

    @CrossOrigin(origins = "http://localhost:4200/users")
    @RequestMapping(value = "/Products/", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String getAllProducts(){
    	log.info("In API.getAllProducts");
    	return (restTemplate.getForObject("http://localhost:8081/products/", String.class));
    }
    
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health(){
        return "OK";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String insertUser(@Valid @RequestBody User user) {
    	log.info("In API.insertUsers");
    	if(userService.createUser(user).equals("success")) {
    		return "OK";
    	}
    	return "Some Error!";
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable("username") String username) {
    	log.info("In API.deleteUser");
    	userService.deleteUser(username);
    }
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public void modifyUser(@Valid @RequestBody User user) {
    	log.info("In API.modifyUser" + user.toString());
        userService.editUser(user);
    } 
}
