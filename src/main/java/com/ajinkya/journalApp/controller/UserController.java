package com.ajinkya.journalApp.controller;

import com.ajinkya.journalApp.entity.Journal;
import com.ajinkya.journalApp.entity.User;
import com.ajinkya.journalApp.service.JournalService;
import com.ajinkya.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    ResponseEntity<? extends Object> getUsers()
    {
        List<User> all = userService.getAllJournalEntries();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }
    @PostMapping
    ResponseEntity<?> setUserEntries(@RequestBody User user)
    {

        userService.saveUser(user);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/id/{myId}")
    HttpEntity<User> getUserById(@PathVariable ObjectId myId)
    {
        Optional<User> myId1= userService.findById(myId);
        if (myId1.isPresent()) return new ResponseEntity<User>(myId1.get(), HttpStatus.OK);
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

//    @DeleteMapping("/id/{myId}")
//    ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId)
//    {
//
//          if( journalService.deleteById(myId))
//          {
//              return new ResponseEntity<>(HttpStatus.OK);
//          }
//          return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

}
