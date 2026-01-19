package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
