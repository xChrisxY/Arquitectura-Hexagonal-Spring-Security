package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.controllers;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.user.CreateUserUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.ApiResponse;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user.UserDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user.UserResponseDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;

    public AuthController(
            CreateUserUseCase createUserUseCase,
            UserMapper userMapper
    ){
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> register(@Valid @RequestBody UserDTO dto){

        User user = userMapper.toDomain(dto);
        User createdUser = createUserUseCase.execute(user);
        UserResponseDTO userResponseDTO = userMapper.toResponseDTO(createdUser);

        ApiResponse<UserResponseDTO> response = new ApiResponse<>("User created successfully", userResponseDTO);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }


}
