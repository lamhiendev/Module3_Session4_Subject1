package com.github.hienlamdev.subject1.service;

import com.github.hienlamdev.subject1.model.Course;
import com.github.hienlamdev.subject1.model.Enrollment;
import com.github.hienlamdev.subject1.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.hienlamdev.subject1.repository.CourseRepository;
import com.github.hienlamdev.subject1.repository.EnrollmentRepository;
import com.github.hienlamdev.subject1.repository.InstructorRepository;

import java.util.List;

@Service
public class CourseManagementService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    @Autowired
    public CourseManagementService(InstructorRepository instructorRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
