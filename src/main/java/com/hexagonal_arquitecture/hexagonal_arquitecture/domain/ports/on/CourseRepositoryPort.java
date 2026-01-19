package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;

import java.util.Optional;

public interface CourseRepositoryPort {
    Course save(Course course);
    Optional<Course> getCourseById(Long courseId);
}
