package com.kitaplik.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(BookNotFoundExcepiton.class)
    private ResponseEntity<?> handle(BookNotFoundExcepiton excepiton){
        return new ResponseEntity<>(excepiton.getMessage(), HttpStatus.NOT_FOUND);
    }


}
