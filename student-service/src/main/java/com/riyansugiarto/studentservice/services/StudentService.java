package com.riyansugiarto.studentservice.services;

import com.riyansugiarto.studentservice.data.StudentDto;
import com.riyansugiarto.studentservice.data.StudentNameResponseDto;
import com.riyansugiarto.studentservice.data.StudentResponseDto;
import com.riyansugiarto.studentservice.mappers.StudentMapper;
import com.riyansugiarto.studentservice.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    @Autowired
    StudentMapper studentMapper;


    public StudentResponseDto saveStudent(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudent(){
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(Integer id){
        return repository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentByFirstName(String name){
        return repository.findAllByFirstNameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public List<StudentNameResponseDto> findAllStudentBySchool(Integer schoolId) {
        return repository.findBySchoolId(schoolId)
                .stream()
                .map(studentMapper::studentNameResponseDto)
                .collect(Collectors.toList());
    }
}
