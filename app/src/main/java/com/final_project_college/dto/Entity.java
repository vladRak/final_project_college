package com.final_project_college.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
//@AllArgsConstructor
public abstract class Entity implements Serializable {
    private long id;

    public Entity(long id) {
        this.id = id;
    }
}
