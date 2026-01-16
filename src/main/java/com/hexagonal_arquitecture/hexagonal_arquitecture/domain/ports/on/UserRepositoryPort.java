package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long userId);
    List<User> findAll();
}
