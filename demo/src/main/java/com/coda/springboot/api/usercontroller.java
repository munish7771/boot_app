package com.coda.springboot.api;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.coda.springboot.models.*;
import com.coda.springboot.repository.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class usercontroller {
    @Autowired
    private userrepository repository;
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<user> getallusers(){
        return repository.findAll();
    }
    // health method
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health(){
        return repository.findUserByName("munish").get(0).password;
    }
    
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public user getUserById(@PathVariable("id") ObjectId id) {
//        return repository.findBy_id(id);
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody user user) {
//        user.set_id(id);
//        repository.save(user);
//    }
//    
    // to fetch users from name
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<user> modifyUserById(@PathVariable("name") String name) {
    	return repository.findUserByName(name);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public user createuser(@Valid @RequestBody user user) {
      user.set_id(ObjectId.get());
      repository.save(user);
      // return the same user
      return user;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteuser(@PathVariable ObjectId id) {
      repository.delete(repository.findBy_id(id));
    }
    
}
