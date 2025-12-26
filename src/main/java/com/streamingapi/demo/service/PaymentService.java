package com.streamingapi.demo.service;
import com.streamingapi.demo.dto.PaymentRequest;
import com.streamingapi.demo.exception.CardNotRegisteredException;
import com.streamingapi.demo.repo.UserMemory;

public class PaymentService {
    private final UserMemory userMemory;

    public PaymentService(UserMemory userMemory) {
        this.userMemory = userMemory;
    }

    public void pay(PaymentRequest request) {
        if (!userMemory.isCardRegistered(request.getCreditCardNumber())) {
            throw new CardNotRegisteredException("Credit card not registered");
        }
    }
    }

