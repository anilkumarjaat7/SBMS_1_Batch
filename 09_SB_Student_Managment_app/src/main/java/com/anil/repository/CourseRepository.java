package com.anil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	

}
