package com.ajinkya.journalApp.service;

import com.ajinkya.journalApp.entity.Journal;
import com.ajinkya.journalApp.entity.User;
import com.ajinkya.journalApp.repository.JournalRepo;
import com.ajinkya.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public String saveUser(User user)
    {
        userRepo.save(user);
        return "added to database";
    }
    public List<User> getAllJournalEntries()
    {
        return userRepo.findAll();
    }
    public Optional<User> findById(ObjectId id)
    {
        return userRepo.findById(id);
    }

    public boolean deleteById(ObjectId myId) {
        userRepo.deleteById(myId);
         return true ;
    }
    public User findByUserName(String  username)
    {
        return userRepo.findByUsername(username);
    }
}
