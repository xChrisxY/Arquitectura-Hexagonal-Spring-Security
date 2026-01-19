package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.course;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;

public interface UpdateCourseUseCase {
    Course execute(Long courseId, Course course);
}