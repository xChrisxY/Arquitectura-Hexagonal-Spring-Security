package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.entities;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.enums.Level;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private float price;
    private Level level;
    private LocalDateTime published;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity professor;

    public CourseEntity(){}

    @PrePersist()
    public void prePersist(){
        this.published = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }

    public UserEntity getProfessor() {
        return professor;
    }

    public void setProfessor(UserEntity professor) {
        this.professor = professor;
    }
}
