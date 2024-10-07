package com.sample.first.springbootapp1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @GetMapping(value = "/")
    public ResponseEntity<String> getAllCoursesHandler(){
        return new ResponseEntity<String>("No Courses Found" , HttpStatus.OK);
    }

}
