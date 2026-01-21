package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases.lesson;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions.CourseNotFoundException;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.lesson.CreateLessonUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.CourseRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.LessonRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CreateLessonUseCaseImpl implements CreateLessonUseCase {

    private final LessonRepositoryPort lessonRepository;
    private final CourseRepositoryPort courseRepository;

    public CreateLessonUseCaseImpl(LessonRepositoryPort lessonRepository, CourseRepositoryPort courseRepository){
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Lesson execute(Long courseId, Lesson lesson){

        Course course = courseRepository.getCourseById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("El curso con el id: " + courseId + " no fue encontrado."));

        lesson.setCourse(course);
        return lessonRepository.save(lesson);

    }

}
