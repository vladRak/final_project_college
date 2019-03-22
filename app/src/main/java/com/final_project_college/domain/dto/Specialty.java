package com.final_project_college.domain.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Specialty extends Entity {

    private String specialtyName;

    @Builder
    private Specialty(long id,
                     String specialtyName) {
        super(id);
        this.specialtyName = specialtyName;
    }

}
