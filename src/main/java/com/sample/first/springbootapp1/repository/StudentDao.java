package com.sample.first.springbootapp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.first.springbootapp1.model.Student;
import com.sample.first.springbootapp1.model.StudentDTO;

public interface StudentDao extends JpaRepository<Student, Integer> {

    @Query("select new com.sample.first.springbootapp1.model.StudentDTO(s.name , s.marks) from Student s where s.roll=:roll")
    public StudentDTO getStudentNameAndMarksByRoll(@Param("roll") Integer roll);
}
