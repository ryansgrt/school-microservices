package com.riyansugiarto.studentservice.data;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email,
        Integer age,
        Integer schoolId
) {
}
