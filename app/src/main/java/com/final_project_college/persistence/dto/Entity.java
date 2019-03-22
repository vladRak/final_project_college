package com.final_project_college.persistence.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
public abstract class Entity implements Serializable {
    private long id;

    public Entity(long id) {
        this.id = id;
    }
}
