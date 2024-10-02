package com.sample.first.springbootapp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.first.springbootapp1.exceptions.StudentException;
import com.sample.first.springbootapp1.model.Student;
import com.sample.first.springbootapp1.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao sDao ;

    @Override
    public List<Student> getAllStudents() {
       List<Student> students =  sDao.findAll() ;
       if(students.size() == 0){
        throw new StudentException("Students are not present in the table") ;
       }
       return students ;
    }

}
