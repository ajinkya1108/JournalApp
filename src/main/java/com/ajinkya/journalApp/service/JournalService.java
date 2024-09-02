package com.ajinkya.journalApp.service;

import com.ajinkya.journalApp.entity.Journal;
import com.ajinkya.journalApp.entity.User;
import com.ajinkya.journalApp.repository.JournalRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {
    @Autowired
    JournalRepo journalRepo;
    @Autowired
    UserService userService;
    @Transactional
    public String saveJournalEntry(Journal journal, String username)
    {
        journal.setDate(LocalDateTime.now());
        User user=userService.findByUserName(username);
        Journal entry=journalRepo.insert(journal);
        user.getJournalList().add(entry);
        user.setPassword(null);
        userService.saveUser(user);
        return "added to database";
    }
    public List<Journal> getAllJournalEntries()
    {
        return journalRepo.findAll();
    }
    public Optional<Journal> findById(ObjectId id)
    {
        return journalRepo.findById(id);
    }

    public boolean deleteById(ObjectId myId) {
         journalRepo.deleteById(myId);
         return true ;
    }
}
