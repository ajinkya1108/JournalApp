package com.ajinkya.journalApp.repository;

import com.ajinkya.journalApp.entity.Journal;
import com.ajinkya.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    public User findByUsername(String username);
}
