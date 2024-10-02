package com.sample.first.springbootapp1.exceptions;

import java.time.LocalDateTime;

public class MyErrorDetails {

    private String message ;
    private String description ;
    private LocalDateTime timestamp ;

    public MyErrorDetails(String message, String description, LocalDateTime timestamp) {
        this.message = message;
        this.description = description;
        this.timestamp = timestamp;
    }

    public MyErrorDetails() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    
}
