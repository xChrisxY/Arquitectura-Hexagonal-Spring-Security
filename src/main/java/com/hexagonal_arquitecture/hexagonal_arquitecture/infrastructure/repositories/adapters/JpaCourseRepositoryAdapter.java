package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.adapters;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.CourseRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.CourseEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.courses.CourseMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaCourseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JpaCourseRepositoryAdapter implements CourseRepositoryPort {

    private final JpaCourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public JpaCourseRepositoryAdapter(JpaCourseRepository courseRepository, CourseMapper courseMapper){
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    @Transactional
    public Course save(Course course){

        CourseEntity courseEntity = courseMapper.toEntity(course);




        CourseEntity createdCourse = courseRepository.save(courseEntity);
        return courseMapper.toDomain(createdCourse);
    }
}
