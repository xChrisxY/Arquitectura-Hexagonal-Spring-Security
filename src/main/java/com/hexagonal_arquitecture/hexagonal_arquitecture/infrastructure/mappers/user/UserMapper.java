package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user.UserDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "password", target = "passwordHash")
    User toDomain(UserDTO dto);

    UserResponseDTO toResponseDTO(User user);

}
