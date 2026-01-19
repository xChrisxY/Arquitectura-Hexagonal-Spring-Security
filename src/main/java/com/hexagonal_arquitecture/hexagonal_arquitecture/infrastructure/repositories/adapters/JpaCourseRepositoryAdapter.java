package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.adapters;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.CourseRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.CourseEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.courses.CourseMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.courses.CoursePersistenceMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaCourseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class JpaCourseRepositoryAdapter implements CourseRepositoryPort {

    private final JpaCourseRepository courseRepository;
    private final CoursePersistenceMapper courseMapper;

    public JpaCourseRepositoryAdapter(JpaCourseRepository courseRepository, CoursePersistenceMapper courseMapper){
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

    @Override
    @Transactional
    public Optional<Course> getCourseById(Long courseId){
        Optional<CourseEntity> entity = courseRepository.findById(courseId);
        return entity.map(courseMapper::toDomain);
    }
}
