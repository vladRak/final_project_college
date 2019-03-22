package com.final_project_college.persistence.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Privilege extends Entity {

    private String privilegeName;

    @Builder
    private Privilege(long id, String privilegeName) {
        super(id);
        this.privilegeName = privilegeName;
    }
}
