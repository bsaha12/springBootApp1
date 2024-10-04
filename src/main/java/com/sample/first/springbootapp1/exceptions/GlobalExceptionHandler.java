package com.sample.first.springbootapp1.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

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

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException nfe, WebRequest wr) {
        System.out.println("Inside No Handler Found Exception Handler Method");

        MyErrorDetails err = new MyErrorDetails();
        err.setDescription(wr.getDescription(false));
        err.setMessage(nfe.getMessage());
        err.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> invalidArgumentHandler(MethodArgumentNotValidException mae, WebRequest wr) {
        System.out.println("Inside Invalid Argument Exception Handler Method");

        MyErrorDetails err = new MyErrorDetails();
        // err.setDescription(wr.getDescription(false));
        err.setDescription(mae.getBindingResult().getFieldError().getDefaultMessage());
        err.setMessage(mae.getMessage());
        err.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> globalExceptionHandler(Exception se, WebRequest wr) {
        System.out.println("Inside Generic Exception Handler Method");

        MyErrorDetails err = new MyErrorDetails();
        err.setDescription(wr.getDescription(false));
        err.setMessage(se.getMessage());
        err.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }
}
