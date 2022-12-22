package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Contact {
    @jakarta.persistence.Id
    @SequenceGenerator(name = "contact_sequence",sequenceName = "contact_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "contact_sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
    private String personContact;
}
