package com.github.hienlamdev.subject1.controller;

import com.github.hienlamdev.subject1.DTO.Response.ApiResponse;
import com.github.hienlamdev.subject1.model.Instructor;
import com.github.hienlamdev.subject1.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        ApiResponse<List<Instructor>> response = new ApiResponse<>(true, "Instructors retrieved successfully", instructors);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable long id) {
        Instructor instructor = instructorService.getInstructorById(id);
        if (instructor != null) {
            ApiResponse<Instructor> response = new ApiResponse<>(true, "Instructor retrieved successfully", instructor);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorService.createInstructor(instructor);
        ApiResponse<Instructor> response = new ApiResponse<>(true, "Instructor created successfully", createdInstructor);
        return ResponseEntity.status(201).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable long id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);
        if (updatedInstructor != null) {
            ApiResponse<Instructor> response = new ApiResponse<>(true, "Instructor updated successfully", updatedInstructor);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteInstructor(@PathVariable long id) {
        instructorService.deleteInstructorById(id);
        ApiResponse<Void> response = new ApiResponse<>(true, "Instructor deleted successfully", null);
        return ResponseEntity.ok(response);
    }
}
