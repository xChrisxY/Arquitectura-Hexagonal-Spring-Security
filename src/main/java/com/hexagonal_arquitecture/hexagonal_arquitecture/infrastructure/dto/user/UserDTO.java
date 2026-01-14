package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotBlank
    @Size(min = 5, max = 15)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(min = 8, max = 25)
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotNull
    @Valid
    private UserProfileDTO profile;

    public UserDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(UserProfileDTO profile) {
        this.profile = profile;
    }
}
