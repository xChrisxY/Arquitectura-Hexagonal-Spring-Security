package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.lesson;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.lesson.LessonDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.lesson.LessonResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    Lesson toDomain(LessonDTO dto);
    LessonResponseDTO toResponseDTO(Lesson lesson);
    List<LessonResponseDTO> toResponseDTOToList(List<Lesson> lessons);

}
