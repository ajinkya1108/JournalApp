package com.ajinkya.journalApp.controller;

import com.ajinkya.journalApp.entity.Journal;
import com.ajinkya.journalApp.entity.User;
import com.ajinkya.journalApp.service.JournalService;
import com.ajinkya.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {
    @Autowired
    JournalService journalService;
    @Autowired
    UserService userService;
    @GetMapping("/{username}")
    ResponseEntity<? extends Object> getAllJournalEntriesOfUsers(@PathVariable String username)
    {
        //User user = userService.findByUserName(username);

        //List<Journal> all = journalService.getAllJournalEntries();
        List <Journal> all=userService.findByUserName(username).getJournalList();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }
    @PostMapping("/{username}")
    ResponseEntity<?> setEntries(@RequestBody Journal journal,@PathVariable String username ) throws Exception {
        try {
            journalService.saveJournalEntry(journal, username);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e )
        {
            return new ResponseEntity<>(e ,HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/id/{myId}")
    HttpEntity<Journal> getJournalById(@PathVariable ObjectId myId)
    {
        Optional<Journal> myId1= journalService.findById(myId);
        if (myId1.isPresent()) return new ResponseEntity<Journal>(myId1.get(), HttpStatus.OK);
        return new ResponseEntity<Journal>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/id/{userName}/{myId}")
    ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId,@PathVariable String userName)
    {

          User user=userService.findByUserName(userName);
          List<Journal> journal=user.getJournalList();
          journal.remove(journalService.findById(myId));
          user.setJournalList(journal);
          userService.saveUser(user);

          if( journalService.deleteById(myId))
          {
              return new ResponseEntity<>(HttpStatus.OK);
          }
          return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
//    @PutMapping("/id/{username}/{myId}")
//    ResponseEntity<?> updateJournalEntry(@PathVariable ObjectId myId,@PathVariable String username,@RequestBody Journal journal)
//    {
//
//
//    }

}
