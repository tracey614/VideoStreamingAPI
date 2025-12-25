package com.streamingapi.demo.controller;
import com.streamingapi.demo.dto.RegisterUserRQ;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserController {
    
   @PostMapping("/users")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserRQ request) {
        // ffor UserService later
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/users")
    public ResponseEntity<Void> getUsers(@RequestParam(name = "CreditCard", required = false) String creditCardFilter) {
        // Do LATER!
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
  
}
@RestController