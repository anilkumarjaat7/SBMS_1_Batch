package com.anil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.entity.Course;
import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Long> {

	Optional<Course> findBySlug(String slug);
	boolean existsBySlug(String slug);

}
