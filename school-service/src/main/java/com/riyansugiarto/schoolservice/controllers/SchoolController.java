package com.riyansugiarto.schoolservice.controllers;

import com.riyansugiarto.schoolservice.data.SchoolDto;
import com.riyansugiarto.schoolservice.data.SchoolResponseDto;
import com.riyansugiarto.schoolservice.data.StudentNameResponseDto;
import com.riyansugiarto.schoolservice.error.ResourceNotFoundException;
import com.riyansugiarto.schoolservice.models.School;
import com.riyansugiarto.schoolservice.response.ApiResponse;
import com.riyansugiarto.schoolservice.services.SchoolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SchoolResponseDto>>> findAllSchools() {
        List<SchoolResponseDto> schools = schoolService.findAllSchools();
        ApiResponse<List<SchoolResponseDto>> response = new ApiResponse<>("success retrieve all schools", schools);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SchoolDto>> createSchool(@Valid @RequestBody SchoolDto schoolDto) {
        SchoolDto createdSchool = schoolService.createSchool(schoolDto);
        ApiResponse<SchoolDto> response = new ApiResponse<>("success create school", createdSchool);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{school-id}")
    public ResponseEntity<ApiResponse<SchoolResponseDto>> findSchoolById(@PathVariable("school-id") Integer id) {
        Optional<School> school = schoolService.findSchoolById(id);
        if (school.isPresent()) {
            SchoolResponseDto schoolResponseDto = new SchoolResponseDto(school.get().getId(), school.get().getName());
            ApiResponse<SchoolResponseDto> response = new ApiResponse<>("success retrieve school by id", schoolResponseDto);
            return ResponseEntity.ok(response);
        } else {
            throw new ResourceNotFoundException("School not found with id: " + id);
        }
    }

    @GetMapping("/students/{school-id}")
    public ResponseEntity<Object> findAllStudentsBySchool(@PathVariable("school-id") Integer school_id) {
        ResponseEntity<Object> students = schoolService.findAllStudentsBySchool(school_id);
        return ResponseEntity.ok(students.getBody());
    }
}

