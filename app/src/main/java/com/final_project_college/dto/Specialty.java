package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Specialty extends Entity {

    private short specialtyCode;
    private String specialtyName;
    private long branchId;

    @Builder
    public Specialty(long id, short specialtyCode,
                     String specialtyName, long branchId) {
        super(id);
        this.specialtyCode = specialtyCode;
        this.specialtyName = specialtyName;
        this.branchId = branchId;
    }

}
