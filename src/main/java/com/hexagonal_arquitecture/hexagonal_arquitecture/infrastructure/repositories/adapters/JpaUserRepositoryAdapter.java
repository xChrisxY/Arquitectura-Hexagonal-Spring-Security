package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.adapters;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions.RoleNotFoundException;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions.UserNotFoundException;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Role;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.UserRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.RoleEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserProfileEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user.UserPersistenceMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaRoleRepository;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;
    private final JpaRoleRepository jpaRoleRepository;
    private final UserPersistenceMapper userMapper;

    public JpaUserRepositoryAdapter(
            JpaUserRepository jpaUserRepository,
            JpaRoleRepository jpaRoleRepository,
            UserPersistenceMapper userMapper
    ){
        this.jpaUserRepository = jpaUserRepository;
        this.jpaRoleRepository = jpaRoleRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public User save(User user){

        UserEntity entity = userMapper.toEntity(user);

        UserProfileEntity profileEntity = entity.getProfile();
        profileEntity.setUser(entity);

        Set<Role> roles = user.getRoles();

        roles.forEach(role -> {
            RoleEntity roleEntity = jpaRoleRepository.findByName(role.getName())
                    .orElseThrow(() -> new RoleNotFoundException("Role not found: " + role.getName()));

            entity.addRole(roleEntity);
        });

        UserEntity createdUser = jpaUserRepository.save(entity);
        return userMapper.toDomain(createdUser);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long userId){

        return jpaUserRepository.findById(userId)
                .map(userMapper::toDomain);

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll(){

        return jpaUserRepository.findAll().stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }

}
