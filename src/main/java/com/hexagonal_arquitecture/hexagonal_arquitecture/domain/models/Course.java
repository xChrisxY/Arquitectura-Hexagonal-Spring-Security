package com.hexagonal_arquitecture.hexagonal_arquitecture.domain.models;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.enums.Level;

import java.time.LocalDateTime;

public class Course {
    private Long id;
    private String title;
    private String description;
    private float price;
    private Level level;
    private LocalDateTime published;

    private User professor;

    public Course(){}

    public void update(String title, String description, float price, Level level){
        this.title = title;
        this.description = description;
        this.price = price;
        this.level = level;
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

    public User getProfessor() {
        return professor;
    }

    public void setProfessor(User professor) {
        this.professor = professor;
    }
}
