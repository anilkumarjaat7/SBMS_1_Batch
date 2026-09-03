package com.anil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anil.entity.Student;
import com.anil.repository.StudentRepository;

@SpringBootApplication
public class Application {

   


   

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		StudentRepository studentRepo = context.getBean(StudentRepository.class);
		
//		Student student = new Student("ram","ram@gmail.com","98374895798");		
//		studentRepo.save(student);
		
//		Student s1 = new Student("syam","ram@gmail.com","98374895798");	
//		Student s2 = new Student("ghsyam","syam@gmail.com","71374895798");	
//		Student s3 = new Student("ram","ram@gmail.com","98374895798");	
//		Student s4 = new Student("sonu","ram@gmail.com","71374895798");	
//		Student s5 = new Student("ram","ram@gmail.com","98374895798");	
//		Student s6 = new Student("ram","ram@gmail.com","71374895798");	
//		
//		List<Student> students = Arrays.asList(s1,s2,s3,s4,s5,s6);
//		studentRepo.saveAll(students);
		
//		Optional<Student> byId = studentRepo.findById(9);
//		
//	   if(byId.isPresent()) {
//		   System.out.println(byId);
//	   }
		

		
//		studentRepo.deleteById(5);
//		studentRepo.deleteAll();
//		
//		List<Student> students = studentRepo.findAll();
//		
//		for(Student s : students) {
//			System.out.println(s);
//		}
		
		List<Student> students = studentRepo.findByName("ram");
		
		
		for(Student s : students) {
			System.out.println(s);
		}
	}

}
