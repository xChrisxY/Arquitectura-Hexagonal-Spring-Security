package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;

public interface LessonRepositoryPort {
    Lesson save(Lesson lesson);
}
