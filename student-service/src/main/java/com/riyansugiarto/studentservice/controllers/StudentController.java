package com.riyansugiarto.studentservice.controllers;

import com.riyansugiarto.studentservice.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto dto){
        return this.studentService.saveStudent(dto);
    }

    @GetMapping
    public List<StudentResponseDto> findAllStudent(){
        return this.studentService.findAllStudent();
    }

    @GetMapping("/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/search/{student-name}")
    public List<StudentResponseDto> findStudentByFirstName(@PathVariable("student-name") String name){
        return studentService.findStudentByFirstName(name);
    }

    @DeleteMapping("/{student-id}")
    public void delete(@PathVariable("student-id") Integer id){
        studentService.delete(id);
    }

    @GetMapping("/schools/{school_id}")
    public ResponseEntity<List<StudentNameResponseDto>> findAllStudentBySchool(@PathVariable Integer school_id){
        return studentService.findAllStudentBySchool(school_id);
    }

}
