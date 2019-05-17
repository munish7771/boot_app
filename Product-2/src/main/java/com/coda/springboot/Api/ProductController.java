package com.coda.springboot.Api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coda.springboot.Bean.Product;
import com.coda.springboot.Service.ProductService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
    	log.info("In API.getAllProducts");
    	return (service.getAllProducts());
    }
 
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health(){
        return "OK";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String insertProduct(@Valid @RequestBody Product product) {
    	log.info("In API.insertProducts");
    	if(service.insertProduct(product).equals("success")) {
    		return "OK";
    	}
    	return "Some Error!";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id) {
    	log.info("In API.deleteProduct");
    	service.deleteProduct(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyProduct(@Valid @RequestBody Product product) {
    	log.info("In API.modifyProduct");
        service.editProduct(product);
    } 
}
