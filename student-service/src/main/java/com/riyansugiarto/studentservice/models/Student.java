package com.riyansugiarto.studentservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 20)
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;
    private Integer schoolId;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private StudentProfile studentProfile;

    public Student(String firstName, String lastName, String email, Integer schoolId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.schoolId= schoolId;
    }

    public String getName(){
        return firstName + " " + lastName;
    }




}
