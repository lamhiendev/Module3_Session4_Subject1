package com.github.hienlamdev.subject1.controller;

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
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable long id) {
        Instructor instructor = instructorService.getInstructorById(id);
        if (instructor != null) {
            return ResponseEntity.ok(instructor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorService.createInstructor(instructor);
        return ResponseEntity.status(201).body(createdInstructor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable long id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);
        if (updatedInstructor != null) {
            return ResponseEntity.ok(updatedInstructor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable long id) {
        instructorService.deleteInstructorById(id);
        return ResponseEntity.noContent().build();
    }
}
