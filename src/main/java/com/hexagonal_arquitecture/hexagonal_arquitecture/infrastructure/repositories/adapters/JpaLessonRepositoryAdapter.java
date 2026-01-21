package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.adapters;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.LessonRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.LessonEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.lesson.LessonPersistenceMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaLessonRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaLessonRepositoryAdapter implements LessonRepositoryPort {

    private final JpaLessonRepository jpaLessonRepository;
    private final LessonPersistenceMapper lessonMapper;

    public JpaLessonRepositoryAdapter(JpaLessonRepository jpaLessonRepository,LessonPersistenceMapper lessonMapper){
        this.jpaLessonRepository = jpaLessonRepository;
        this.lessonMapper = lessonMapper;
    }

    @Override
    @Transactional
    public Lesson save(Lesson lesson){

        LessonEntity entity = lessonMapper.toEntity(lesson);
        LessonEntity createdLesson = jpaLessonRepository.save(entity);
        return lessonMapper.toDomain(createdLesson);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Lesson> findAllByCourse(Long courseId){

        List<LessonEntity> entities = jpaLessonRepository.findLessonsByCourseId(courseId);
        return entities.stream().map(lessonMapper::toDomain).collect(Collectors.toList());

    }
}
