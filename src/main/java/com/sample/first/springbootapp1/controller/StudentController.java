package com.sample.first.springbootapp1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.sample.first.springbootapp1.model.Student;
import com.sample.first.springbootapp1.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class StudentController {

    @Autowired
    private StudentService sService;

    @GetMapping("/student/fetchAll")
    public List<Student> getAllStudentsHandler() {
        return sService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentByIdHandler(@PathVariable("id") Integer roll) {
        return sService.getStudentByRoll(roll);
    }

    @PostMapping("/student/create")
    public Student createStudentHandler(@Valid @RequestBody Student student) {
        return sService.createStudent(student);
    }

    @PutMapping("/student/update")
    public Student updateStudentHandler(@RequestBody Student student) {
        return sService.updateStudent(student);
    }

    // @PutMapping("path/{id}")
    // public String UpdateStudent(@PathVariable String id, @RequestBody String entity) {
    //     //TODO: process PUT request
        
    //     return entity;
    // }

    @DeleteMapping("/student/{id}")
    public Student deleteStudentHandler(@PathVariable("id") Integer roll){
        return sService.deleteStudent(roll);
    }

}
