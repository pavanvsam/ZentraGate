package com.zentra.zentragate.controller;

import com.zentra.zentragate.util.exception.MediaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MediaNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMediaNotFound(MediaNotFoundException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Media not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, String>> handleNPE(NullPointerException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Unexpected null value");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}