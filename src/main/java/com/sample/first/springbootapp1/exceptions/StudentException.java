package com.sample.first.springbootapp1.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentException extends RuntimeException {

    public StudentException(String message) {
        super(message);
    }
}
