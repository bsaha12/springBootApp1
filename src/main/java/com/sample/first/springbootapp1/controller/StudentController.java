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
        return new ResponseEntity<List<Student>>(sService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentByIdHandler(@PathVariable("id") Integer roll) {
        Student student = sService.getStudentByRoll(roll);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PostMapping("/student/create")
    public ResponseEntity<Student> createStudentHandler(@Valid @RequestBody Student student) {
        return new ResponseEntity<Student>(sService.createStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/student/update")
    public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) {
        return new ResponseEntity<Student>(sService.updateStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudentHandler(@PathVariable("id") Integer roll) {
        return new ResponseEntity<Student>(sService.deleteStudent(roll), HttpStatus.OK);
    }

    @GetMapping("/students/fetchMarksAndRoll/{roll}")
    public ResponseEntity<StudentDTO> fetchMarksAndRollHandler(@PathVariable() Integer roll) {
        return new ResponseEntity<StudentDTO>(sService.fetchMarksAndRoll(roll), HttpStatus.OK);
    }

}
