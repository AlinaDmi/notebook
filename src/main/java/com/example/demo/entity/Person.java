package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Getter
public class Person {
    @Id
    @SequenceGenerator(name = "person_sequence",sequenceName = "person_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "person_sequence")
    private Long id;
    private String name;
}
