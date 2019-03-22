package com.final_project_college.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class College extends Entity {

    private String name;
    private String description;

    @Builder
    private College(long id, String name,
                    String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
