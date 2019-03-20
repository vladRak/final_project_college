package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Privilege extends Entity {

    private String privilegeName;

    @Builder
    public Privilege(long id, String privilegeName) {
        super(id);
        this.privilegeName = privilegeName;
    }
}
