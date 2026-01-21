package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;

import java.util.List;

public interface LessonRepositoryPort {
    Lesson save(Lesson lesson);
    List<Lesson> findAllByCourse(Long courseId);
}
