package com.final_project_college.domain.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Entity implements Serializable {
    private long id;

    public Entity(long id) {
        this.id = id;
    }
}
