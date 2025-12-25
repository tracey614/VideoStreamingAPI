package com.streamingapi.demo.controller;
import com.streamingapi.demo.dto.PaymentRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class PaymentController {
     @PostMapping("/payments")
    public ResponseEntity<Void> makePayment(@Valid @RequestBody PaymentRequest request) {
        // call PaymentService later
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
