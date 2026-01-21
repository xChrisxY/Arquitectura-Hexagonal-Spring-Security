package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.controllers;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Course;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Lesson;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.course.CreateCourseUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.course.UpdateCourseUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.lesson.CreateLessonUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.lesson.ListLessonsByCourseUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.ApiResponse;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.courses.CourseDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.courses.CourseResponseDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.lesson.LessonDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.lesson.LessonResponseDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.courses.CourseMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.lesson.LessonMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.security.utils.SecurityUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final CreateLessonUseCase createLessonUseCase;
    private final ListLessonsByCourseUseCase listLessonsByCourseUseCase;

    private final LessonMapper lessonMapper;
    private final CourseMapper courseMapper;

    public CourseController(
            CreateCourseUseCase createCourseUseCase,
            UpdateCourseUseCase updateCourseUseCase,
            CreateLessonUseCase createLessonUseCase,
            ListLessonsByCourseUseCase listLessonsByCourseUseCase,
            LessonMapper lessonMapper,
            CourseMapper courseMapper
    ){
        this.createCourseUseCase = createCourseUseCase;
        this.updateCourseUseCase = updateCourseUseCase;
        this.createLessonUseCase = createLessonUseCase;
        this.listLessonsByCourseUseCase = listLessonsByCourseUseCase;
        this.lessonMapper = lessonMapper;
        this.courseMapper = courseMapper;
    }

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> create(@Valid @RequestBody CourseDTO dto){

        String professor = SecurityUtils.getCurrentUsername();
        Course newCourse = courseMapper.toDomain(dto);
        Course cratedCourse = createCourseUseCase.execute(newCourse, professor);
        CourseResponseDTO courseResponseDTO = courseMapper.toResponseDTO(cratedCourse);

        ApiResponse<CourseResponseDTO> response = new ApiResponse<>(
                "Course created successfully",
                courseResponseDTO
        );

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

    @PreAuthorize("@courseSecurity.isOwner(#courseId)")
    @PutMapping("/{courseId}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> update(@PathVariable Long courseId, @Valid @RequestBody CourseDTO dto){

        Course courseData = courseMapper.toDomain(dto);
        Course updatedCourse = updateCourseUseCase.execute(courseId, courseData);
        CourseResponseDTO courseResponseDTO = courseMapper.toResponseDTO(updatedCourse);

        ApiResponse<CourseResponseDTO> response = new ApiResponse<>(
                "Course updated successfully",
                courseResponseDTO
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @PreAuthorize("@courseSecurity.isOwner(#courseId)")
    @PostMapping("/{courseId}/lessons")
    public ResponseEntity<ApiResponse<LessonResponseDTO>> createLesson(@PathVariable Long courseId, @Valid @RequestBody LessonDTO dto){

        Lesson newLesson = lessonMapper.toDomain(dto);
        Lesson createdLesson = createLessonUseCase.execute(courseId, newLesson);
        LessonResponseDTO lessonResponseDTO = lessonMapper.toResponseDTO(createdLesson);

        ApiResponse<LessonResponseDTO> response = new ApiResponse<>(
                "Lesson created successfully",
                lessonResponseDTO
        );

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

    @GetMapping("/{courseId}/lessons")
    public ResponseEntity<ApiResponse<List<LessonResponseDTO>>> listLessons(@PathVariable Long courseId){

        List<Lesson> lessons = listLessonsByCourseUseCase.execute(courseId);
        List<LessonResponseDTO> lessonResponseDTOS = lessonMapper.toResponseDTOToList(lessons);

        ApiResponse<List<LessonResponseDTO>> response = new ApiResponse<>(
                "Lessons retreived successfully",
                lessonResponseDTOS
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}
