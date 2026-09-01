package com.anil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.entity.Student;

public interface StudentRepositeory extends JpaRepository<Student, Long>{

}
