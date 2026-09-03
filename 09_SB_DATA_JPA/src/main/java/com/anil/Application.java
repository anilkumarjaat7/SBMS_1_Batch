package com.anil;

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
		
		User user = new User();
		user.setName("sonu");
		user.setEmail("sonu@gmail.com");
		user.setHight(4.4);
		user.setAge(16);
		
	 repo.save(user);
		
	}

}
