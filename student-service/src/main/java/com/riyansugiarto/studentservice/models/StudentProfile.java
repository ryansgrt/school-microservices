package com.riyansugiarto.studentservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfile {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String phoneNumber;

    @Column(length = 100)
    private String address;


    private String bio;
    @OneToOne
    @JoinColumn(
    name = "student_id"
    )
    @JsonBackReference
    private Student student;

}
