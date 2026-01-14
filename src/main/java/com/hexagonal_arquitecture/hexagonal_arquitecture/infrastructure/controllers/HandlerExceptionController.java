package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.controllers;

import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> methodArgumentNotValid(MethodArgumentNotValidException e){

        Map<String, String> errors = new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        fieldErrors.forEach(error -> {
            errors.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
        });

        ApiResponse<Map<String, String>> error = new ApiResponse<>(
                "Error de validación en el cuerpo de la petición",
                errors
        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(error);
    }
}
