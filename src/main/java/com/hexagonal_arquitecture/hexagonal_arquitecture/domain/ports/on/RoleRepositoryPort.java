package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Role;

public interface RoleRepositoryPort {
    Role getRoleByName(String name);
}
