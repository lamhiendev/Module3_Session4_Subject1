package com.github.hienlamdev.subject1.repository;

import com.github.hienlamdev.subject1.model.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository() {

        enrollments.add(new Enrollment(1001L, "Le Van C", 101L));
        enrollments.add(new Enrollment(1002L, "Nguyen Thi D", 102L));
    }
    public List<Enrollment> findAll() {
        return enrollments;
    }
}
