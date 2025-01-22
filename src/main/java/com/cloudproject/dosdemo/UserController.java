/**
 * 
 */
package com.cloudproject.dosdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Save User
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
    	
        userRepository.save(user);
        
        System.out.println(user.getFirstName() + " saved successfully , user id : " + user.getId());
        
        return ResponseEntity.ok("User saved successfully!");
    }

    // Get All Users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
    	
        List<User> users = userRepository.findAll();
        
        return ResponseEntity.ok(users);
    }

  
  
}


