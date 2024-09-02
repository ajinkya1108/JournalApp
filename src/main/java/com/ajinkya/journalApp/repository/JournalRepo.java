package com.ajinkya.journalApp.repository;

import com.ajinkya.journalApp.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface JournalRepo extends MongoRepository<Journal, ObjectId> {
}
