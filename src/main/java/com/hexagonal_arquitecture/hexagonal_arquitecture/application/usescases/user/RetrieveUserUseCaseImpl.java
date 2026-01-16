package com.hexagonal_arquitecture.hexagonal_arquitecture.application.usescases.user;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.exceptions.UserNotFoundException;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.User;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.in.user.RetrieveUserUseCase;
import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.UserRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepository;

    public RetrieveUserUseCaseImpl(UserRepositoryPort userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId){

        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("El usuario con el id " + userId + " no fue encontrado."));

    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
