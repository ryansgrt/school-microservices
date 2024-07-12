package com.riyansugiarto.schoolservice.services;

import com.riyansugiarto.schoolservice.data.SchoolDto;
import com.riyansugiarto.schoolservice.data.SchoolResponseDto;
import com.riyansugiarto.schoolservice.data.StudentNameResponseDto;
import com.riyansugiarto.schoolservice.feign.StudentInterface;
import com.riyansugiarto.schoolservice.mappers.SchoolMapper;
import com.riyansugiarto.schoolservice.models.School;
import com.riyansugiarto.schoolservice.repositories.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {

    @Autowired
    SchoolRepository repository;

    @Autowired
    SchoolMapper schoolMapper;

    @Autowired
    StudentInterface studentClient;

    public List<SchoolResponseDto> findAllSchools() {

        return repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolResponseDto)
                .collect(Collectors.toList());
    }

    public SchoolDto createSchool(SchoolDto schoolDto) {
        var school = schoolMapper.toSchool(schoolDto);
        var savedSchool = repository.save(school);
        return schoolMapper.toSchoolDto(savedSchool);
    }

    public Optional<School> findSchoolById(Integer id) {
        return repository.findById(id);
    }


    public ResponseEntity<Object> findAllStudentsBySchool(Integer school_id) {
        return studentClient.findAllStudentBySchool(school_id);
    }
}
