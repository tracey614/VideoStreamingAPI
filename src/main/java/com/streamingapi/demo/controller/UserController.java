package com.streamingapi.demo.controller;

import com.streamingapi.demo.dto.RegisterUserRQ;
import com.streamingapi.demo.model.user;
import com.streamingapi.demo.repo.UserMemory;
import com.streamingapi.demo.service.UserService;
import jakarta.validation.Valid;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
@RestController
public class UserController {
    
    private final UserService userService;
    public UserController() {
        UserMemory userMemory = new UserMemory();
        this.userService = new UserService(userMemory);
        
    }

   @PostMapping("/users")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserRQ request) {
        userService.register(request);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

  @GetMapping("/users")
public ResponseEntity<Collection<user>> getUsers(
        @RequestParam(name = "CreditCard", required = false) String filter) {

    Boolean hasCard = null;

    if (filter != null) {
        if ("Yes".equalsIgnoreCase(filter)) {
            hasCard = true;
        } else if ("No".equalsIgnoreCase(filter)) {
            hasCard = false;
        }
    }

    return ResponseEntity.ok(userService.listUsers(hasCard));
}

  
}
