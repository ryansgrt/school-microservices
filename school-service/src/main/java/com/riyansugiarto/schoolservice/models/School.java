package com.riyansugiarto.schoolservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String name;

    public School(String name) {
        this.name = name;
    }

}
