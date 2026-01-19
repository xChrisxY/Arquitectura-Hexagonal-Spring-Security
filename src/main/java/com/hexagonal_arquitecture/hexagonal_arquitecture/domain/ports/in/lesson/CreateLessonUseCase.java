package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.lesson;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;

public interface CreateLessonUseCase {
    Lesson execute(Lesson lesson);
}
