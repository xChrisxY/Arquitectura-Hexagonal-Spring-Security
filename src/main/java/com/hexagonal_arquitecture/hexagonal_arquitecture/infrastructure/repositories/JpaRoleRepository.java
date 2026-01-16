package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories;

import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
}
