package com.final_project_college.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class CollegeSpecialty extends Entity {

    private long collegeId;
    private long specialtyId;
    private int governmentOrder;
    private int contractOrder;

    @Builder
    private CollegeSpecialty(long id, long collegeId,
                             long specialtyId, int governmentOrder,
                             int contractOrder) {
        super(id);
        this.collegeId = collegeId;
        this.specialtyId = specialtyId;
        this.governmentOrder = governmentOrder;
        this.contractOrder = contractOrder;
    }
}
