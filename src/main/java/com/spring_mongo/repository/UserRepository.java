package com.spring_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.spring_mongo.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{


}
