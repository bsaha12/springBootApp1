package com.sample.first.springbootapp1.service;

import java.util.List;

import com.sample.first.springbootapp1.model.Student;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentByRoll(Integer roll);

    public Student createStudent(Student student);

    public Student updateStudent(Student Student);

    public Student deleteStudent(Integer roll);

}
