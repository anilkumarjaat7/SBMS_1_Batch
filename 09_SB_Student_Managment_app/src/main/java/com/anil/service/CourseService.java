package com.anil.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anil.entity.Course;
import com.anil.repository.CourseRepository;



@Service
public class CourseService{

    private final CourseRepository courseRepository;

    private final Path uploadRoot;

    public CourseService(
            CourseRepository courseRepository,
            @Value("${app.upload-dir}") String uploadDir
    ) {
        this.courseRepository = courseRepository;
        this.uploadRoot = Paths.get(uploadDir).toAbsolutePath().normalize();
    }

    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

  
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));
    }

    
    public Course saveCourse(
            Course course,
            MultipartFile bannerImg,
            MultipartFile cardImg,
            MultipartFile coursePdf
    ) {

        try {

            Course savedCourse = course.getId() == null
                    ? course
                    : getCourseById(course.getId());

            savedCourse.setName(course.getName());
            savedCourse.setTitle(course.getTitle());
            savedCourse.setSlug(normalizeSlug(course.getSlug(), course.getTitle()));
            savedCourse.setShortDescription(course.getShortDescription());
            savedCourse.setDescription(course.getDescription());
            savedCourse.setHighlights(normalizeJson(course.getHighlights()));
            savedCourse.setCourseCurriculum(normalizeJson(course.getCourseCurriculum()));
            savedCourse.setFee(course.getFee());
            savedCourse.setDuration(course.getDuration());
            savedCourse.setIsFeatured(course.getIsFeatured() != null && course.getIsFeatured());

            // Create folders
            Path imageDirectory = uploadRoot.resolve("courses/images");
            Path pdfDirectory = uploadRoot.resolve("courses/pdfs");

            Files.createDirectories(imageDirectory);
            Files.createDirectories(pdfDirectory);

            // Banner Image
            if (bannerImg != null && !bannerImg.isEmpty()) {

                String fileName =
                        saveFile(bannerImg, imageDirectory);

                savedCourse.setBannerImg(
                        "/uploads/courses/images/" + fileName
                );
            }

            // Card Image
            if (cardImg != null && !cardImg.isEmpty()) {

                String fileName =
                        saveFile(cardImg, imageDirectory);

                savedCourse.setCardImg(
                        "/uploads/courses/images/" + fileName
                );
            }

            // PDF
            if (coursePdf != null && !coursePdf.isEmpty()) {

                String fileName =
                        saveFile(coursePdf, pdfDirectory);

                savedCourse.setCourseContent(
                        "/uploads/courses/pdfs/" + fileName
                );
            }

            return courseRepository.save(savedCourse);

        } catch (IOException e) {

            throw new RuntimeException(
                    "File upload failed", e
            );
        }
    }

        private String normalizeJson(String value) {
                return value == null || value.trim().isEmpty() ? "[]" : value.trim();
        }

        private String normalizeSlug(String slug, String title) {
                String value = slug == null || slug.trim().isEmpty() ? title : slug;
                return value.trim().toLowerCase()
                                .replaceAll("[^a-z0-9]+", "-")
                                .replaceAll("^-|-$", "");
        }

    private String saveFile(
            MultipartFile file,
            Path directory
    ) throws IOException {

        String originalName =
                file.getOriginalFilename();

        String extension = "";

        if (originalName != null &&
                originalName.contains(".")) {

            extension =
                    originalName.substring(
                            originalName.lastIndexOf(".")
                    );
        }

        String fileName =
                UUID.randomUUID() + extension;

        Path path = directory.resolve(fileName);

        Files.copy(
                file.getInputStream(),
                path,
                StandardCopyOption.REPLACE_EXISTING
        );

        return fileName;
    }

    
    public void deleteCourse(Long id) {

        Course course = getCourseById(id);

                deleteFile(course.getBannerImg());
                deleteFile(course.getCardImg());
                deleteFile(course.getCourseContent());

        courseRepository.delete(course);
    }

        private void deleteFile(String publicPath) {
                if (publicPath == null || publicPath.isBlank()) {
                        return;
                }

                String relativePath = publicPath.replaceFirst("^/uploads/", "");
                Path file = uploadRoot.resolve(relativePath).normalize();

                if (file.startsWith(uploadRoot)) {
                        try {
                                Files.deleteIfExists(file);
                        } catch (IOException e) {
                                throw new RuntimeException("Could not delete uploaded file", e);
                        }
                }
        }
}