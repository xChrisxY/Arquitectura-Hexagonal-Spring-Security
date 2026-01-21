package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases.lesson;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions.CourseNotFoundException;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.lesson.ListLessonsByCourseUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.CourseRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.LessonRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListLessonsByCourseUseCaseImpl implements ListLessonsByCourseUseCase {

    private final LessonRepositoryPort lessonRepository;
    private final CourseRepositoryPort courseRepository;

    public ListLessonsByCourseUseCaseImpl(LessonRepositoryPort lessonRepository, CourseRepositoryPort courseRepository){
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Lesson> execute(Long courseId){

        courseRepository.getCourseById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("El curso con el id: " + courseId + " no fue encontrado"));

        return lessonRepository.findAllByCourse(courseId);
    }

}
