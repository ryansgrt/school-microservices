package com.riyansugiarto.studentservice.controllers;

import com.riyansugiarto.studentservice.data.StudentDto;
import com.riyansugiarto.studentservice.data.StudentNameResponseDto;
import com.riyansugiarto.studentservice.data.StudentResponseDto;
import com.riyansugiarto.studentservice.error.ResourceNotFoundException;
import com.riyansugiarto.studentservice.response.ApiResponse;
import com.riyansugiarto.studentservice.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponseDto>> saveStudent(@Valid @RequestBody StudentDto dto) {
        StudentResponseDto studentResponse = studentService.saveStudent(dto);
        ApiResponse<StudentResponseDto> response = new ApiResponse<>("success insert data student", studentResponse);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponseDto>>> findAllStudent() {
        List<StudentResponseDto> students = studentService.findAllStudent();
        ApiResponse<List<StudentResponseDto>> response = new ApiResponse<>("success retrieve all students", students);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<StudentResponseDto>> findStudentById(@PathVariable("student-id") Integer id) {
        StudentResponseDto student = studentService.findStudentById(id);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        ApiResponse<StudentResponseDto> response = new ApiResponse<>("success retrieve student by id", student);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/{student-name}")
    public ResponseEntity<ApiResponse<List<StudentResponseDto>>> findStudentByFirstName(@PathVariable("student-name") String name) {
        List<StudentResponseDto> students = studentService.findStudentByFirstName(name);
        ApiResponse<List<StudentResponseDto>> response;
        if (students.isEmpty()){
            response = new ApiResponse<>("success data not found", students);
        } else{
            response = new ApiResponse<>("success retrieve students by first name", students);
        }


        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable("student-id") Integer id) {
        studentService.delete(id);
        ApiResponse<Void> response = new ApiResponse<>("success delete student", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/schools/{school_id}")
    public ResponseEntity<ApiResponse<List<StudentNameResponseDto>>> findAllStudentBySchool(@PathVariable Integer school_id) {
        List<StudentNameResponseDto> students = studentService.findAllStudentBySchool(school_id);
        ApiResponse<List<StudentNameResponseDto>> response;
        if (students.isEmpty()){
            response = new ApiResponse<>("data student(s) not found", students);
        } else {
            response = new ApiResponse<>("success retrieve students by school", students);
        }


        return ResponseEntity.ok(response);
    }
}
