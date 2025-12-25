package com.streamingapi.demo.service;
import com.streamingapi.demo.dto.RegisterUserRQ;
import com.streamingapi.demo.exception.CardNotRegisteredException;
import com.streamingapi.demo.exception.UnderageException;
import com.streamingapi.demo.exception.UsernameExistsException;
import com.streamingapi.demo.model.user;
import com.streamingapi.demo.repo.UserMemory;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

import org.apache.catalina.User;

public class UserService {
  private final UserMemory repository;
    public UserService(UserMemory repository) {
        this.repository = repository;
    }

 public void register(RegisterUserRQ request) {

        int age = Period.between(request.getDateOfBirth(), LocalDate.now()).getYears();
        if (age < 18) {
            throw new UnderageException("User must be at least 18 years old");
        }

        if (repository.existsByUsername(request.getUsername())) {
            throw new UsernameExistsException("Username already exists");
        }

       user user = new user(
                request.getUsername(),
                request.getPassword(),
                request.getEmail(),
                request.getDateOfBirth(),
                request.getCreditCardNumber()
        );

        repository.save(user);
    }

    public Collection<user> listUsers(Boolean hasCard) {
        if (hasCard == null) {
            return repository.findAll();
        }
        return repository.findUsersWithCard(hasCard);
    }
    
}
