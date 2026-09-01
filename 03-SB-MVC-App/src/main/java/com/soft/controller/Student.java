package com.soft.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Student {
	
	@GetMapping("/student")
	public String student( Model model) {
		String name = "Lokesh";
		int age = 22;
		String city = "Delhi";
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);

		model.addAttribute("city", city);

		return "student";
	}
	
	
	@GetMapping("/students")
	public String getStudents(Model model) {
		List<String> studentList = Arrays.asList("ram","syam","ghansyam","sumit","amit");
		
		model.addAttribute("students", studentList);
		
		return "students";
	}

}
