package com.anil.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.anil.config.FileResourceConfig;
import com.anil.entity.Course;
import com.anil.repository.CourseRepository;


@Service
public class CourseService {

    private final FileResourceConfig fileResourceConfig;
	
	private final CourseRepository repo;
	
	private final Path uploadRoot;
	
	public CourseService(CourseRepository repo,  @Value("${app.upload-dir}") String uploadDir, FileResourceConfig fileResourceConfig) {
		super();
		this.repo = repo;
		  this.uploadRoot = Paths.get(uploadDir).toAbsolutePath().normalize();
		  this.fileResourceConfig = fileResourceConfig;
	}


	public List<Course> getAllCourses(){
		return repo.findAll();
	}
	
	
	
	
	public Course getCourseById(Long id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("Course not found"));
	}
	
	
	
	public Course saveCourse(
			Course course,
			MultipartFile bannerImg,
			MultipartFile cardImg,
			MultipartFile coursePdf
			) {
		
	try {
		
	Course savedCourse =	course.getId() ==null
				? course : getCourseById(course.getId());
	
	
	savedCourse.setName(course.getName());
	savedCourse.setTitle(course.getTitle());
	savedCourse.setSlug(course.getSlug());
	savedCourse.setShortDescription(course.getShortDescription());
	savedCourse.setDescription(course.getDescription());
	
	savedCourse.setHighlights(course.getHighlights());
	savedCourse.setCourseCurriculum(course.getCourseCurriculum());
	
	savedCourse.setFee(course.getFee());
	savedCourse.setDuration(course.getDuration());
	savedCourse.setIsFeatured(course.getIsFeatured() != null && course.getIsFeatured());
	
	Files.createDirectories(imageDirectory);
	Files.createDirectories(pdfDirectory);
	
//	Banner Iamge
	if(bannerImg != null && !bannerImg.isEmpty()) {
	String fileName =	saveFile(bannerImg,imageDirectory);
	savedCourse.setBannerImg(
"/uploads/courses/images/"+ fileName);
	}
	
//	Card Image
	
//	Pdf
	
	
	}catch(Exception ex){
		System.out.println(ex);
		
	}
		
		
	}
	
	
	

}
