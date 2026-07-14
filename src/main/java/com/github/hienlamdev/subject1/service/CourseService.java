package com.github.hienlamdev.subject1.service;

import com.github.hienlamdev.subject1.model.Course;
import com.github.hienlamdev.subject1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course createCourse(Course course) {
        courseRepository.create(course);
        return course;
    }

    public Course updateCourse(Long id, Course course) {
        courseRepository.update(id, course);
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course deleteCourseById(Long id) {
        Course deleted = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.deleteById(id);
        return deleted;
    }
}
