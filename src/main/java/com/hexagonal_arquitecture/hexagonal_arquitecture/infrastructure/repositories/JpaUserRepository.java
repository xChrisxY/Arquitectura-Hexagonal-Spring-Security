package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories;

import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
