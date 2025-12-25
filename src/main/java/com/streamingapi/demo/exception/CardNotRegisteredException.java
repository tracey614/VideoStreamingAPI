package com.streamingapi.demo.exception;

public class CardNotRegisteredException extends RuntimeException {
    public CardNotRegisteredException(String message) {
        super(message);
    }
    
}
