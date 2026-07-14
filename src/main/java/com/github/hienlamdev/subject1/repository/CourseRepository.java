package com.github.hienlamdev.subject1.repository;

import com.github.hienlamdev.subject1.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}


