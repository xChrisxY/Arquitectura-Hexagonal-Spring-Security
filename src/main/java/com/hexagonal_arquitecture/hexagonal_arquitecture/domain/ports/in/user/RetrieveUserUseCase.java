package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.user;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;

import java.util.List;

public interface RetrieveUserUseCase {
    User getUserById(Long userId);
    List<User> getAllUsers();
}
