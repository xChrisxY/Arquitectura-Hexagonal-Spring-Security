package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserProfileDTO {

    @JsonProperty("first_name")
    @NotBlank
    private String firstName;
    @JsonProperty("last_name")
    @NotBlank
    private String lastName;
    @NotNull
    @Min(18)
    private Integer age;
    @NotBlank
    @Size(min = 10, max = 50)
    private String bio;

    public UserProfileDTO(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
