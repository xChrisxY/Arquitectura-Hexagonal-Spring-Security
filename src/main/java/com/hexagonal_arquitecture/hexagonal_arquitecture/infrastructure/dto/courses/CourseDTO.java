package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.courses;

import com.hexagonal_arquitecture.hexagonal_arquitecture.domain.enums.Level;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CourseDTO {

    @NotBlank
    @Column(unique = true)
    @Size(min = 3, max = 50)
    private String title;

    @NotBlank
    @Size(min = 10)
    private String description;

    @NotNull
    @Min(1)
    private float price;

    @NotNull
    private Level level;

    public CourseDTO(){}

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

}
