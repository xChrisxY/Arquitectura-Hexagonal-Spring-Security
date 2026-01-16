package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;

public interface CourseRepositoryPort {
    Course save(Course course);
}
