package com.anil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.anil.entity.Course;
import com.anil.service.CourseService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
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
	
	@PostMapping("/save")
	public String saveCourse(
			@ModelAttribute Course course ,
			
			@RequestParam(value="bannerFile", required = false )
					MultipartFile bannerImg,
					
					@RequestParam(value="cardFile", required = false )
					MultipartFile cardImg,
					
					@RequestParam(value="coursePdf", required = false )
					MultipartFile coursepdf ) {
		
		
		service.saveCourse(course,bannerImg,cardImg,coursepdf);
		
		return "redirect:/courses";
	}
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable Long id,Model model) {
		model.addAttribute("course", service.getCourseById(id));
		return "courses/form";
	}
	
	
	
	@GetMapping("/{id}")
	public String viewCourse(@PathVariable Long id, Model model) {
		Course course = service.getCourseById(id);
		
		model.addAttribute("course", course);
		
		return "courses/view";
	}
	
	
	
//	Delete
	@GetMapping("/delete/{id}")
	public String deleteCourse(@PathVariable Long id) {
		
		service.deleteCourse(id);
		return"redirect:/courses";
		
	}
	

}


// email
