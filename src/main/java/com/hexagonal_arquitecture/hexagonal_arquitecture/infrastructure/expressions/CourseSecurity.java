package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.expressions;

import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaCourseRepository;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.security.utils.SecurityUtils;
import org.springframework.stereotype.Component;

@Component("courseSecurity")
public class CourseSecurity {

    private final JpaCourseRepository jpaCourseRepository;

    public CourseSecurity(JpaCourseRepository jpaCourseRepository){
        this.jpaCourseRepository = jpaCourseRepository;
    }

    public boolean isOwner(Long courseId){
        String username = SecurityUtils.getCurrentUsername();
        return jpaCourseRepository.existsByIdAndProfessorUsername(courseId, username);
    }

}
