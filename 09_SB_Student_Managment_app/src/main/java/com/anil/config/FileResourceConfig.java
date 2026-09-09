package com.anil.config;


import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class FileResourceConfig implements WebMvcConfigurer{

	private final String uploadLocation;
	
	 public FileResourceConfig(@Value("${app.upload-dir}") String uploadDir) {
	        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
	        this.uploadLocation = uploadPath.toUri().toString();
	    }
	
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations(uploadLocation + "/");
	}
	
	
}
