package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.courses;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseEntity toEntity(Course course);
    Course toDomain(CourseEntity entity);

}
