package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Specialty extends Entity {

    private String specialtyName;

    @Builder
    public Specialty(long id,
                     String specialtyName) {
        super(id);
        this.specialtyName = specialtyName;
    }

}
