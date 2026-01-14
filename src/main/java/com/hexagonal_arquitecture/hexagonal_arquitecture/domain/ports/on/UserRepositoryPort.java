package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;

public interface UserRepositoryPort {
    User save(User user);
}
