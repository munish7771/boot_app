package com.coda.springboot;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/products")
public class productcontroller {
	
    @Autowired
    private productrepository repository;
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<product> getallproducts(){
        return repository.findAll();
    }
    
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health(){
        return repository.findProductByName("apple").get(0).description;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<product> findproductbyid(@PathVariable("name") String name) {
    	return repository.findProductByName(name);
    }
    
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public product createuser(@Valid @RequestBody product product) {
      product.set_id(ObjectId.get());
      repository.save(product);
      // return the same product
      return product;
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteproduct(@PathVariable ObjectId id) {
      repository.delete(repository.findBy_id(id));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody product product) {
        product.set_id(id);
        repository.save(product);
    } 
}
