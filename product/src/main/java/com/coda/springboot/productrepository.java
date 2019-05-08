package com.coda.springboot;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface productrepository extends MongoRepository<product, String>{

	product findBy_id(ObjectId _id);
	
    @Query("{'name' : ?0 }")
    List<product> findProductByName(String name);
}
