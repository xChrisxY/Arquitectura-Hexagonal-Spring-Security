package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
