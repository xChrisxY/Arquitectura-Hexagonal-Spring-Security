package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.role;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Role;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RolePersistenceMapper {

    RoleEntity toEntity(Role role);
    Role toDomain(RoleEntity entity);

}
