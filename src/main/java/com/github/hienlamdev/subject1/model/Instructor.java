package com.github.hienlamdev.subject1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.format.jakartajson.JakartaJsonIntegration;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 100,nullable = false)
    private String name;
    @Column(name = "email",nullable = false)
    private String email;
}
