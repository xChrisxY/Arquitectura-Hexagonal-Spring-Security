package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.adapters;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.UserRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user.UserPersistenceMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;
    private final UserPersistenceMapper userMapper;

    public JpaUserRepositoryAdapter(
            JpaUserRepository jpaUserRepository,
            UserPersistenceMapper userMapper
    ){
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user){

        UserEntity entity = userMapper.toEntity(user);
        UserEntity createdUser = jpaUserRepository.save(entity);
        return userMapper.toDomain(createdUser);

    }

}
