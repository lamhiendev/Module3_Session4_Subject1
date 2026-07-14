package com.github.hienlamdev.subject1.controller;

import com.github.hienlamdev.subject1.DTO.Response.ApiResponse;
import com.github.hienlamdev.subject1.model.Enrollment;
import com.github.hienlamdev.subject1.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        ApiResponse<List<Enrollment>> response = new ApiResponse<>(true, "Enrollments retrieved successfully", enrollments);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        ApiResponse<Enrollment> response = new ApiResponse<>(true, "Enrollment retrieved successfully", enrollment);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Enrollment>> createEnrollment(@RequestBody Enrollment enrollment) {
        enrollmentService.createEnrollment(enrollment);
        ApiResponse<Enrollment> response = new ApiResponse<>(true, "Enrollment created successfully", enrollment);
        return ResponseEntity.status(201).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        Enrollment enrollment_updated = enrollmentService.updateEnrollment(id, enrollment);
        if(enrollment_updated == null){
            return ResponseEntity.notFound().build();
        }
        ApiResponse<Enrollment> response = new ApiResponse<>(true, "Enrollment updated successfully", enrollment_updated);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEnrollment(@PathVariable Long id) {
        Enrollment deleted = enrollmentService.deleteEnrollmentById(id);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        ApiResponse<Void> response = new ApiResponse<>(true, "Enrollment deleted successfully", null);
        return ResponseEntity.ok(response);
    }
}
