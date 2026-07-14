package com.github.hienlamdev.subject1.service;

import com.github.hienlamdev.subject1.model.Instructor;
import com.github.hienlamdev.subject1.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;
    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    public Instructor createInstructor(Instructor instructor) {
        instructorRepository.create(instructor);
        return instructor;
    }

    public Instructor updateInstructor(Long id, Instructor instructor) {
        instructorRepository.update(id, instructor);
        return instructorRepository.findById(id);
    }

    public Instructor deleteInstructorById(Long id) {
        Instructor deleted = instructorRepository.findById(id);
        if (deleted != null) {
            instructorRepository.deleteById(id);
        }
        return deleted;
    }
}
