package com.project_xy_backend.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final UUID id;

    @NotBlank(message = "Field name must not be blank")
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public UUID getId() {
        return id;
    }
}
