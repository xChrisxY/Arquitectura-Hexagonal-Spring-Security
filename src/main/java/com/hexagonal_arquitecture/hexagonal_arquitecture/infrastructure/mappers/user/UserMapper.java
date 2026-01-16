package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.UserProfile;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user.UserDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user.UserProfileDTO;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "password", target = "passwordHash")
    User toDomain(UserDTO dto);

    UserResponseDTO toResponseDTO(User user);

    List<UserResponseDTO> toResponseDTOToList(List<User> users);

}
