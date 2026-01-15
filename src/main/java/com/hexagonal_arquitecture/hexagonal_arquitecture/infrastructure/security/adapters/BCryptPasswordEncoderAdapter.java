package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.security.adapters;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on.PasswordEncoderPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderAdapter implements PasswordEncoderPort {

    private final PasswordEncoder passwordEncoder;

    public BCryptPasswordEncoderAdapter(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }
}
