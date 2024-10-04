package com.sample.first.springbootapp1.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {

    private String message;
    private String description;
    private LocalDateTime timestamp;

}
