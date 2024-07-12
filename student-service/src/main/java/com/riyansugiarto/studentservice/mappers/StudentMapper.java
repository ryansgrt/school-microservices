package com.riyansugiarto.studentservice.mappers;

import com.riyansugiarto.studentservice.data.StudentDto;
import com.riyansugiarto.studentservice.data.StudentNameResponseDto;
import com.riyansugiarto.studentservice.data.StudentResponseDto;
import com.riyansugiarto.studentservice.models.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        if(dto == null){
            throw new NullPointerException("The student Dto is null");
        }

        return new Student(
                dto.firstName(),
                dto.lastName(),
                dto.email(),
                dto.age(),
                dto.schoolId()
        );
    }

    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge(),
                student.getSchoolId()
        );
    }



    public StudentNameResponseDto studentNameResponseDto(Student student){
        return new StudentNameResponseDto(student.getName(), student.getAge(), student.getEmail());
    }
}
