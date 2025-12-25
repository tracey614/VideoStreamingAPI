package com.streamingapi.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

public class RegisterUserRQ {
    //Validating useraname 
    @NotBlank(message = "Username is required")
    private String username;
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username must be alphanumeric and have no spaces")
     private String password;

     //validating password
     @NotBlank(message = "Password required")
     //>=8chars, at least 1 uppercase and 1 digit
     @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)\\S{8,}$", message = "Password must be at least 8 characters, with at least one upper case letter and number")  //does not allow spaces
     private String confirmPassword;

    //validating email
    @NotBlank(message = "Email is required")    
    @Email(message = "Email should be a valid email address")
     private String email;

    //validating date of birth
    @NotNull(message = "Date of Birth is required")
    @JsonFormat(pattern = "yyyy-MM-dd") //ISO 8601 format
    private LocalDate dateOfBirth;

    //optional credit card field
    @Pattern(regexp = "^(\\d{16})?$", message = "Credit Card number must be 16 digits") //allows null for optionality
    private String creditCardNumber;

    //Getters and Setters
    public String getUsername() 
        { return username; }
    public void setUsername(String username) 
        { this.username = username; }

    public String getPassword() 
        { return password; }
    public void setPassword(String password) 
        { this.password = password; }

    public String getEmail() 
        { return email; }
    public void setEmail(String email) 
        { this.email = email; }

    public LocalDate getDateOfBirth() 
        { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) 
        { this.dateOfBirth = dateOfBirth; }

    public String getCreditCardNumber() 
        { return creditCardNumber; }
    public void setCreditCardNumber(String creditCardNumber) 
        { this.creditCardNumber = creditCardNumber; }
}

