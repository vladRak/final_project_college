package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class College extends Entity {

    private String name;
    private String description;

    @Builder
    public College(long id, String name,
                   String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
