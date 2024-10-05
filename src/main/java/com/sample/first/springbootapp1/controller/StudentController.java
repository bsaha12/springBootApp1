package com.sample.first.springbootapp1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.sample.first.springbootapp1.model.Student;
import com.sample.first.springbootapp1.model.StudentDTO;
import com.sample.first.springbootapp1.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getAllStudentsHandler() {
        return new ResponseEntity<List<Student>>(sService.getAllStudents() , HttpStatus.OK) ;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentByIdHandler(@PathVariable("id") Integer roll) {
        Student student =  sService.getStudentByRoll(roll);
        return new ResponseEntity<Student>(student , HttpStatus.OK);
    }

    @PostMapping("/student/create")
    public Student createStudentHandler(@Valid @RequestBody Student student) {
        return sService.createStudent(student);
    }

    @PutMapping("/student/update")
    public Student updateStudentHandler(@RequestBody Student student) {
        return sService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public Student deleteStudentHandler(@PathVariable("id") Integer roll) {
        return sService.deleteStudent(roll);
    }

    @GetMapping("/students/fetchMarksAndRoll/{roll}")
    public StudentDTO fetchMarksAndRollHandler(@PathVariable() Integer roll) {
        return sService.fetchMarksAndRoll(roll);
    }

}
