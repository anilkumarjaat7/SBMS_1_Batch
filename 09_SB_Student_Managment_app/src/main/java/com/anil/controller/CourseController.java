package com.anil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.anil.entity.Course;
import com.anil.service.CourseService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor

public class CourseController {
	
	private final CourseService service;
	
//	Get All Courses
	@GetMapping
	public String courses(Model model) {
		model.addAttribute("courses", service.getAllCourses());
		
		return "courses/list";
	}
	
//	create Form
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("course", new Course());
		
		return "courses/form";
	}
	

}
