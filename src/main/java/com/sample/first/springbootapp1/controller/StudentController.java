package com.sample.first.springbootapp1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.sample.first.springbootapp1.model.Student;
import com.sample.first.springbootapp1.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class StudentController {

    @Autowired
    private StudentService sService ;

    @GetMapping("/students/fetchAll")
    public List<Student> getAllStudentsHandler() {
        return sService.getAllStudents() ;
    }
    
    @GetMapping("/students/{id}")
    public Student getStudentByIdHandler(@PathVariable("id") Integer roll){
        return sService.getStudentByRoll(roll) ;
    }

    @PostMapping("/student/create")
    public Student createStudentHandler(@RequestBody Student student) {
       return sService.createStudent(student);
    }
    
    
}
