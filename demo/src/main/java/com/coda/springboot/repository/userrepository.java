package com.coda.springboot.repository;

import com.coda.springboot.models.*;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface userrepository extends MongoRepository<user,String>{
    user findBy_id(ObjectId _id);
    
    @Query("{'name' : ?0 }")
    List<user> findUserByName(String name);
}