package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories;

import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {

}
