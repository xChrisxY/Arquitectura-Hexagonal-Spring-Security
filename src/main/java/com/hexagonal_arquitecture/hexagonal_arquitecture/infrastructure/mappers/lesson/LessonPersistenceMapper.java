package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.lesson;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.LessonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonPersistenceMapper {

    @Mapping(target = "course", ignore = true)
    LessonEntity toEntity(Lesson lesson);
    @Mapping(target = "course", ignore = true)
    Lesson toDomain(LessonEntity entity);

}
