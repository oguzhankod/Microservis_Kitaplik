package com.kitaplik.libraryservice.exception;

import com.kitaplik.bookservice.exception.BookNotFoundExcepiton;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(com.kitaplik.bookservice.exception.BookNotFoundExcepiton.class)
    private ResponseEntity<?> handle(BookNotFoundExcepiton excepiton){
        return new ResponseEntity<>(excepiton.getMessage(), HttpStatus.NOT_FOUND);
    }


}
