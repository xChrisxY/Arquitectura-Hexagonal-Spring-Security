package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.user;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;

public interface CreateUserUseCase {
    User execute(User user);
}
