package com.anil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.entity.Student;
import com.anil.repository.StudentRepositeory;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepositeory repo;
	

	
//	ADD
	
	public void addStudent(Student student) {
	repo.save(student);
	}
	
	
//	Read All Data
	
	public List<Student> getAllStudents(){
		return repo.findAll();
	}
	
	

}

