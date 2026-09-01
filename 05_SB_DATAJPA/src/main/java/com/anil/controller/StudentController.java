package com.anil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anil.entity.Student;
import com.anil.service.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	public StudentService service;
	
	
	
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	

//	Get All Studnets
	  @GetMapping("/")
    public String students(Model model) {

        model.addAttribute(
                "students",
                service.getAllStudents()
        );

        return "index";
    }

	
//	show Add Student Form
	  @GetMapping("/add")
	    public String addStudentForm(Model model) {

	        Student student = new Student();

	        model.addAttribute("student", student);

	        return "add-student";
	    }
	
	
//	Save Student
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		service.addStudent(student);
		return "redirect:/student/";
		
	}
	
	
	
	
	
	
	
	// @RequestPararam   search?name=Anil
      @GetMapping("/search")
    public String search(Model mode, @RequestParam String name) {
    	
    	return "students";
    }

}




// @pathvariable  /student/101