package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.course;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;

public interface CreateCourseUseCase {
    Course execute(Course course);
}
