package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.CreateUserUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.UserRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort){
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User execute(User user){
        return userRepositoryPort.save(user);
    }

}


