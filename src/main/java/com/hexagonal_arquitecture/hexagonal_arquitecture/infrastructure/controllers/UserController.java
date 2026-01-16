package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.controllers;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.user.RetrieveUserUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.ApiResponse;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user.UserResponseDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RetrieveUserUseCase retrieveUserUseCase;
    private final UserMapper userMapper;

    public UserController(
            RetrieveUserUseCase retrieveUserUseCase,
            UserMapper userMapper
    ){
        this.retrieveUserUseCase = retrieveUserUseCase;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> list(){

        List<User> users = retrieveUserUseCase.getAllUsers();
        List<UserResponseDTO> responseDTOList =  userMapper.toResponseDTOToList(users);

        ApiResponse<List<UserResponseDTO>> response = new ApiResponse<>(
                "Users obtained successfully",
                responseDTOList
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> findById(@PathVariable Long userId){

        User user = retrieveUserUseCase.getUserById(userId);
        UserResponseDTO userResponseDTO = userMapper.toResponseDTO(user);

        ApiResponse<UserResponseDTO> response = new ApiResponse<>(
                "User obtained successfully",
                userResponseDTO
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}
