package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models.UserProfile;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private UserProfileEntity profile;

    public UserEntity(){}

    @PrePersist
    public void prePersist(){
        this.enabled = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(UserProfileEntity profile) {
        this.profile = profile;
    }
}
