package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.ports.on;

public interface PasswordEncoderPort {
    String encode(String rawPassword);
}
