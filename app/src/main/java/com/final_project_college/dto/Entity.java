package com.final_project_college.dto;

import lombok.Data;

import java.io.Serializable;

//@Getter
//@ToString
//@EqualsAndHashCode
@Data
public abstract class Entity implements Serializable {
    private long id;

    public Entity(long id) {
        this.id = id;
    }
}
