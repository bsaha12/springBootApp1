package com.sample.first.springbootapp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.first.springbootapp1.model.Student;

public interface StudentDao extends JpaRepository<Student , Integer> {

}
