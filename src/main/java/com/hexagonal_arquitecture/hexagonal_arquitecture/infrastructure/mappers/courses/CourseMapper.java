package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.courses;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.courses.CourseDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.courses.CourseResponseDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toDomain(CourseDTO dto);
    CourseResponseDTO toResponseDTO(Course course);

}
