package com.anil.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.anil.model.Student;

@Service
public class StudentService {
	
	private ArrayList<Student> students =  new ArrayList<>();
	
	public StudentService() {
		students.add( new Student(101, "amit", "java Full Stack", "Jaipur"));
		students.add( new Student(102, "sumit", "python Full Stack", "delhi"));
		students.add( new Student(103, "sunil", "java Full Stack", "Jaipur"));
		students.add( new Student(104, "mohit", "python Full Stack", "nodia"));
		students.add( new Student(105, "ram", "java Full Stack", "delhi"));
		students.add( new Student(106, "amit", "Mern Full Stack", "noida"));
		students.add( new Student(107, "lokesh", "java Full Stack", "Jaipur"));
		students.add( new Student(108, "amit", "Mern Full Stack", "Delhi"));

	}
	

	
//	ADD
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	
//	Read All Data
	
	public ArrayList<Student> getAllStudents(){
		return students;
	}

}
