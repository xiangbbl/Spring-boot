package com.example.demo1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;

public class Person {

    private final Long id;
    @NonNull
    private final String name;

    public Person(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
