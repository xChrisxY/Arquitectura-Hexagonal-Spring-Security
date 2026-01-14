package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    UserEntity toEntity(User user);
    User toDomain(UserEntity entity);

}
