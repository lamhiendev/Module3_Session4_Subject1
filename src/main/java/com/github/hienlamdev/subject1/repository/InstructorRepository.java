package com.github.hienlamdev.subject1.repository;

import com.github.hienlamdev.subject1.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {
    private final List<Instructor> instructors = new ArrayList<>();

    public InstructorRepository() {
        instructors.add(new Instructor(1L, "Dr. Nguyen Van A", "a.nguyen@university.edu.vn"));
        instructors.add(new Instructor(2L, "Prof. Tran Thi B", "b.tran@university.edu.vn"));
    }
    public List<Instructor> findAll() {
        return instructors;
    }
}
