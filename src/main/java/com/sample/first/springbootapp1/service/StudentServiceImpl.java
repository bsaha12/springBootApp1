package com.sample.first.springbootapp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.first.springbootapp1.exceptions.StudentException;
import com.sample.first.springbootapp1.model.Student;
import com.sample.first.springbootapp1.model.StudentDTO;
import com.sample.first.springbootapp1.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao sDao;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = sDao.findAll();
        if (students.size() == 0) {
            throw new StudentException("Students are not present in the table");
        }
        return students;
    }

    @Override
    public Student getStudentByRoll(Integer roll) {
        System.out.println("Roll No : " + roll);
        Optional<Student> opt = sDao.findById(roll);
        if (opt.isPresent()) {
            return opt.get();
        }

        throw new StudentException("Student Not present with roll : " + roll);
    }

    @Override
    public Student createStudent(Student student) {
        return sDao.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> opt = sDao.findById(student.getRoll());
        if (!opt.isPresent()) {
            throw new StudentException("Student not found");
        }
        return sDao.save(student);
    }

    @Override
    public Student deleteStudent(Integer roll) {
        Optional<Student> opt = sDao.findById(roll);
        if (!opt.isPresent()) {
            throw new StudentException("Student not found");
        }

        sDao.deleteById(roll);
        return opt.get();
    }

    @Override
    public StudentDTO fetchMarksAndRoll(Integer roll) {
        StudentDTO sDto = sDao.getStudentNameAndMarksByRoll(roll);
        if (sDto == null) {
            throw new StudentException("Student Not Found");
        }

        return sDto;
    }

}
