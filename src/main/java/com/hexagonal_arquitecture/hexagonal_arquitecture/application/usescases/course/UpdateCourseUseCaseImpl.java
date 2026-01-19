package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases.course;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions.CourseNotFoundException;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.course.UpdateCourseUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.CourseRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCourseUseCaseImpl implements UpdateCourseUseCase {

    private final CourseRepositoryPort courseRepository;

    public UpdateCourseUseCaseImpl(CourseRepositoryPort courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Course execute(Long courseId, Course course){

        Course existingCourse = courseRepository.getCourseById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("El curso con el id: " + courseId + " no fue encontrado"));

        existingCourse.update(
                course.getTitle(),
                course.getDescription(),
                course.getPrice(),
                course.getLevel()
        );

        return courseRepository.save(existingCourse);
    }
}