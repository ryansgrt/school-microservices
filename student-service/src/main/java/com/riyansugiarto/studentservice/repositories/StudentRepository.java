package com.riyansugiarto.studentservice.repositories;

import com.riyansugiarto.studentservice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstNameContaining(String firstname);
    List<Student> findBySchoolId(Integer school_id);
}
