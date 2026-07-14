package com.github.hienlamdev.subject1.repository;

import com.github.hienlamdev.subject1.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(101L, "Object-Oriented Programming", "Active", 1L));
        courses.add(new Course(102L, "Web Development with Spring Boot", "Pending", 2L));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findById(Long id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return Optional.of(course);
            }
        }

        return Optional.empty();
    }
    public void create(Course course) {
        courses.add(course);
    }
    public Course update(Long id, Course course) {
        Course existing = findById(id).orElseThrow(()-> new RuntimeException("Course not found"));
        existing.setStatus(course.getStatus());
        existing.setTitle(course.getTitle());
        return existing;
    }
    public boolean deleteById(Long id) {
        Course existing = findById(id).orElseThrow(()-> new RuntimeException("Course not found"));
        courses.remove(existing);
        return true;
    }
}


