package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases.course;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.course.CreateCourseUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.CourseRepositoryPort;

public class CreateCourseUseCaseImpl implements CreateCourseUseCase {

    private final CourseRepositoryPort courseRepository;

    public CreateCourseUseCaseImpl(CourseRepositoryPort courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Course execute(Course course){
        return null;

    }
}
