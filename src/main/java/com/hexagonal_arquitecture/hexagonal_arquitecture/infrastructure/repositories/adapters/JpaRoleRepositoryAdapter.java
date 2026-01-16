package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.adapters;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions.RoleNotFoundException;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Role;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.RoleRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.RoleEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.role.RolePersistenceMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaRoleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class JpaRoleRepositoryAdapter implements RoleRepositoryPort {

    private final JpaRoleRepository roleRepository;
    private final RolePersistenceMapper roleMapper;

    public JpaRoleRepositoryAdapter(JpaRoleRepository roleRepository, RolePersistenceMapper roleMapper){
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleByName(String name){

        Optional<RoleEntity> optionalRole = roleRepository.findByName(name);

        if (optionalRole.isEmpty()){
            throw new RoleNotFoundException(String.format("Role con el nombre %s no fue encontrado", name));
        }

        RoleEntity roleEntity = optionalRole.get();
        return roleMapper.toDomain(roleEntity);
    }
}
