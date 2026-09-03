package com.anil;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anil.entity.User;
import com.anil.repository.UserRepository;

@SpringBootApplication
public class Application {

  
  

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		UserRepository repo = context.getBean(UserRepository.class);
		
//		User user = new User();
//		user.setName("rahul");
//		user.setEmail("rahul@gmail.com");
//		user.setHight(5.7);
//		user.setAge(25);
//		
//	 repo.save(user);
		
//		saveAll  findById  findAll()  count() 
	 
		
//		List<User> ageUser = repo.findByAgeGreaterThan(20);
//		
//		for(User u : ageUser) {
//	   System.out.println(u);
		
		
//		List<User> searchByName = repo.searchByName("monu");
//		
////		searchByName.forEach(System.out::println);
//		
//		for(User u :searchByName) {
//		System.out.println(u);
//			
//		}
		
		
		int updateAge = repo.updateAge(2,40);
		
		Optional<User> user = repo.findById(2);
	 
		
System.out.println(user);
	

	 
		
		
		
	}

}
