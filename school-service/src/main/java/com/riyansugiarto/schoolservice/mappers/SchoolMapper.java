package com.riyansugiarto.schoolservice.mappers;

import com.riyansugiarto.schoolservice.data.SchoolDto;
import com.riyansugiarto.schoolservice.data.SchoolResponseDto;
import com.riyansugiarto.schoolservice.models.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {


    public School toSchool(SchoolDto dto){
        return new School(dto.name());
    }

    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }

    public SchoolResponseDto toSchoolResponseDto(School school){

        return new SchoolResponseDto(
                school.getId(),
                school.getName()
        );
    }
}
