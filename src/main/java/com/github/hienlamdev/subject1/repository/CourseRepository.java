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

    public Course findById(Long id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }
    public void create(Course course) {
        courses.add(course);
    }
    public void update(Long id, Course course) {
        for(Course c : courses) {
            if(c.getId().equals(id)) {
                c.setInstructorId(course.getInstructorId());
                c.setStatus(course.getStatus());
                c.setTitle(course.getTitle());
                return;
            }
        }
    }
    public void deleteById(Long id) {
        courses.removeIf(c -> c.getId().equals(id));
    }
}


