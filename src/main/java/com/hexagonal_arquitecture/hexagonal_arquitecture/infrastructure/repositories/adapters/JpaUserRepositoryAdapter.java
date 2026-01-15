package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.adapters;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.UserProfile;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.UserRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities.UserProfileEntity;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.mappers.user.UserPersistenceMapper;
import com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.repositories.JpaUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public User save(User user){

        UserEntity entity = userMapper.toEntity(user);

        UserProfileEntity profileEntity = entity.getProfile();
        profileEntity.setUser(entity);

        UserEntity createdUser = jpaUserRepository.save(entity);
        return userMapper.toDomain(createdUser);

    }

}
