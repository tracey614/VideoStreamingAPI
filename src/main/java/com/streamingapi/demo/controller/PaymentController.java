package com.streamingapi.demo.controller;
import com.streamingapi.demo.dto.PaymentRequest;
import com.streamingapi.demo.repo.UserMemory;
import com.streamingapi.demo.service.PaymentService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class PaymentController {

    
    private final PaymentService paymentService;

    public PaymentController() {
        UserMemory userMemory = new UserMemory();
        this.paymentService = new PaymentService(userMemory);
    }


     @PostMapping("/payments")
    public ResponseEntity<Void> makePayment(@Valid @RequestBody PaymentRequest request) {
         paymentService.pay(request);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
