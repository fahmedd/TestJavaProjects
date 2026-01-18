package org.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<String> handleNoCurrencyException(Exception e){
        return ResponseEntity.noContent().build();
    }


}
