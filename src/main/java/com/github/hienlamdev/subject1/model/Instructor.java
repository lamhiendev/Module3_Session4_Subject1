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
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}
