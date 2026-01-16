package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.UserProfile;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    @Mapping(target = "roles", ignore = true)
    UserEntity toEntity(User user);

    @Mapping(target = "profile.user", ignore = true)
    User toDomain(UserEntity entity);

    @Mapping(target = "user", ignore = true)
    UserProfileEntity toEntity(UserProfile profile);

    @Mapping(target = "user", ignore = true)
    UserProfile toDomain(UserProfileEntity entity);

}
