package com.sample.first.springbootapp1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.sample.first.springbootapp1.model.Student;
import com.sample.first.springbootapp1.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {

    @Autowired
    private StudentService sService ;

    @GetMapping("/students/fetchAll")
    public List<Student> getMethodName() {
        return sService.getAllStudents() ;
    }
    
}
