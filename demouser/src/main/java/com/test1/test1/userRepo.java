package com.test1.test1;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepo extends MongoRepository<user, String> {


    user findBy_id(ObjectId _id);

}
