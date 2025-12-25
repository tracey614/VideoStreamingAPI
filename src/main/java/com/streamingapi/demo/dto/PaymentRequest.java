package com.streamingapi.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PaymentRequest {

    @NotBlank(message = "creditCardNumber is required")
    @Pattern(regexp = "^\\d{16}$", message = "creditCardNumber must be exactly 16 digits")
    private String creditCardNumber;

    @NotBlank(message = "amount is required")
    @Pattern(regexp = "^\\d{3}$", message = "amount must be a 3-digit number")
    private String amount;


    //getters and setters
    public String getCreditCardNumber() 
    { return creditCardNumber;}
    public void setCreditCardNumber(String creditCardNumber) 
    { this.creditCardNumber = creditCardNumber; }

    public String getAmount() 
    { return amount; }
    public void setAmount(String amount) 
    { this.amount = amount; }

}
