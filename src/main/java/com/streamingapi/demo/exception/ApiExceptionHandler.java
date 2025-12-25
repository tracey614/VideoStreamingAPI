package com.streamingapi.demo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice

public class ApiExceptionHandler {
    //handles duplicate usernames, should return status 409
    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<String> handleUsernameExistsException(UsernameExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    //handles underage registration attempts, should return status 403
    @ExceptionHandler(UnderageException.class)
    public ResponseEntity<String> handleUnderageException(UnderageException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
    //handles unregistered card payment attempts, should return status 404
    @ExceptionHandler(CardNotRegisteredException.class)
    public ResponseEntity<String> handleCardNotRegisteredException(CardNotRegisteredException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }   
}
