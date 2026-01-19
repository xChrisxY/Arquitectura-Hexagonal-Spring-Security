package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.courses;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CoursePersistenceMapper {

    @Mapping(target = "professor.profile.user", ignore = true)
    @Mapping(target = "professor.courses", ignore = true)
    Course toDomain(CourseEntity entity);

    @Mapping(target = "professor.profile.user", ignore = true)
    @Mapping(target = "professor.courses", ignore = true)
    CourseEntity toEntity(Course course);

}
