package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.UserProfile;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.CreateUserUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.PasswordEncoderPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.UserRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoder;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoder){
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User execute(User user){

        String encodedPassword = passwordEncoder.encode(user.getPasswordHash());

        UserProfile profile = user.getProfile();
        profile.setUser(user);

        user.setPasswordHash(encodedPassword);
        return userRepositoryPort.save(user);
    }

}


