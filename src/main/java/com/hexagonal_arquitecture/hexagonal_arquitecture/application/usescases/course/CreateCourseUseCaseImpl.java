package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases.course;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.course.CreateCourseUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.CourseRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.UserRepositoryPort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CreateCourseUseCaseImpl implements CreateCourseUseCase {

    private final CourseRepositoryPort courseRepository;
    private final UserRepositoryPort userRepository;

    public CreateCourseUseCaseImpl(CourseRepositoryPort courseRepository, UserRepositoryPort userRepository){
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Course execute(Course course, String professor){

        User professorCourse = userRepository.findByUsername(professor)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con el username: " + professor + " no fue encontrado."));

        course.setProfessor(professorCourse);
        return courseRepository.save(course);
    }
}
