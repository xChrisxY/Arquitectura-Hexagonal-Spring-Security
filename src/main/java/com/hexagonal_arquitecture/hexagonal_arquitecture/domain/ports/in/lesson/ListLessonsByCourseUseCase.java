package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.lesson;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;

import java.util.List;

public interface ListLessonsByCourseUseCase {
    List<Lesson> execute(Long courseId);
}
