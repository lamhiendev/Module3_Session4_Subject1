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

    public Enrollment findById(Long id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId().equals(id)) {
                return enrollment;
            }
        }
        return null;
    }

    public void create(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void update(Long id, Enrollment enrollment) {
        for (Enrollment e : enrollments) {
            if (e.getId().equals(id)) {
                e.setStudentName(enrollment.getStudentName());
                e.setCourseId(enrollment.getCourseId());
                return;
            }
        }
    }

    public void deleteById(Long id) {
        enrollments.removeIf(e -> e.getId().equals(id));
    }
}
