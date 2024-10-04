package com.sample.first.springbootapp1.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<MyErrorDetails> studentExceptionHandler(StudentException se, WebRequest wr) {
        System.out.println("Inside Student Exception Handler Method");

        MyErrorDetails err = new MyErrorDetails();
        err.setDescription(wr.getDescription(false));
        err.setMessage(se.getMessage());
        err.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> globalExceptionHandler(Exception se, WebRequest wr) {
        System.out.println("Inside Global Exception Handler Method");

        MyErrorDetails err = new MyErrorDetails();
        err.setDescription(wr.getDescription(false));
        err.setMessage(se.getMessage());
        err.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }
}
