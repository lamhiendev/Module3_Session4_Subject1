package com.github.hienlamdev.subject1.controller;

import com.github.hienlamdev.subject1.DTO.Response.ApiResponse;
import com.github.hienlamdev.subject1.model.Course;
import com.github.hienlamdev.subject1.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        ApiResponse<List<Course>> response = new ApiResponse<>(true, "Courses retrieved successfully", courses);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        ApiResponse<Course> response = new ApiResponse<>(true, "Course retrieved successfully", course);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        ApiResponse<Course> response = new ApiResponse<>(true, "Course created successfully", createdCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Long id, @RequestBody Course course) {
       try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Course updated successfully", courseService.updateCourse(id, course)));
       } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, e.getMessage(), null)); // 404 Not Found
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(new ApiResponse<>(true, "Course deleted successfully", courseService.deleteCourseById(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, e.getMessage(), null)); // 404 Not Found
        }
    }
}