package com.github.hienlamdev.subject1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseStatus status;
    @Column(name = "instructor_id", nullable = false)
    private Long instructorId;
}
