package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases.user;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.Role;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.UserProfile;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.user.CreateUserUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.PasswordEncoderPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.RoleRepositoryPort;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.UserRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepository;
    private final RoleRepositoryPort roleRepository;
    private final PasswordEncoderPort passwordEncoder;

    public CreateUserUseCaseImpl(
            UserRepositoryPort userRepository,
            PasswordEncoderPort passwordEncoder,
            RoleRepositoryPort roleRepository
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User execute(User user){

        String encodedPassword = passwordEncoder.encode(user.getPasswordHash());

        UserProfile profile = user.getProfile();
        profile.setUser(user);

        Role role = roleRepository.getRoleByName("ROLE_STUDENT");

        user.setPasswordHash(encodedPassword);
        user.addRole(role);
        return userRepository.save(user);
    }

}


