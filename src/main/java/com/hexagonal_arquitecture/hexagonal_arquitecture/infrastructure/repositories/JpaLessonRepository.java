package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories;

import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaLessonRepository extends JpaRepository<LessonEntity, Long> {
    List<LessonEntity> findLessonsByCourseId(Long courseId);
}
