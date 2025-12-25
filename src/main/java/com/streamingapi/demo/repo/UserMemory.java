package com.streamingapi.demo.repo;
import java.time.LocalDate;

public class UserMemory {
    
private final String username;
private final String password;
private final String email;
private final LocalDate dateOfBirth;
private final String creditCardNumber;

public User(String username, String password, String email, LocalDate dateOfBirth, String creditCardNumber) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.creditCardNumber = creditCardNumber;
}
public String getUsername() 
{ return username;}
public String getPassword() 
{ return password;} 
public String getEmail() 
{ return email;}
public LocalDate getDateOfBirth() 
{ return dateOfBirth;}
public String getCreditCardNumber() 
{ return creditCardNumber;}

}
