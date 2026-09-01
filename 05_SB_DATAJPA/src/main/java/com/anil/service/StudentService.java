package com.anil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.entity.Student;
import com.anil.reporitery.StudentReposetry;

@Service
public class StudentService {

	@Autowired
	private StudentReposetry repo;
	
	
	
	 
	 
//	 Read All Method
	 public List<Student> getAllStudents() {
	        return repo.findAll();
	    }

//	 ADD
	 public void addStudent(Student student) {
		repo.save(student);
	 }
	 
	 
	 
//	 Find By Id

	 public Student getStudentById(int id) {
		 return repo.findById(id).orElse(null);
	 }
}
