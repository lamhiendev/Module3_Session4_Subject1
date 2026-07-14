package com.github.hienlamdev.subject1.controller;

import com.github.hienlamdev.subject1.model.Course;
import com.github.hienlamdev.subject1.model.Enrollment;
import com.github.hienlamdev.subject1.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.hienlamdev.subject1.service.CourseManagementService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CourseManagementController {
    private final CourseManagementService courseManagementService;
    @Autowired
    public CourseManagementController(CourseManagementService courseManagementService) {
        this.courseManagementService = courseManagementService;
    }
    @GetMapping("/instructors")
    public List<Instructor> getInstructors() {
        return courseManagementService.getAllInstructors();
    }
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseManagementService.getAllCourses();
    }
    @GetMapping("/enrollments")
    public List<Enrollment> getEnrollments() {
        return courseManagementService.getAllEnrollments();
    }
}
