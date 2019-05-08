package com.test1.test1;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class restController {

    @Autowired
    private userRepo repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<user> getAllUser() {
        return repository.findAll();
    }

    @RequestMapping(value = "/single", method = RequestMethod.POST)
    public user createUser(@Valid @RequestBody user user) {
        user.set_id(ObjectId.get());
        repository.save(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public user getUserById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody user user) {
        user.set_id(id);
        repository.save(user);
    }


}
