package com.github.hienlamdev.subject1.service;

import com.github.hienlamdev.subject1.model.Enrollment;
import com.github.hienlamdev.subject1.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        enrollmentRepository.create(enrollment);
        return enrollment;
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        enrollmentRepository.update(id, enrollment);
        return enrollmentRepository.findById(id);
    }

    public Enrollment deleteEnrollmentById(Long id) {
        Enrollment deleted = enrollmentRepository.findById(id);
        if (deleted != null) {
            enrollmentRepository.deleteById(id);
        }
        return deleted;
    }
}
