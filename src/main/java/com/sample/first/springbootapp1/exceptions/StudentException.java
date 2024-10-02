package com.sample.first.springbootapp1.exceptions;

public class StudentException extends RuntimeException {

    public StudentException(){
        super() ;
    }

    public StudentException(String message){
        super(message) ;
    }
}
