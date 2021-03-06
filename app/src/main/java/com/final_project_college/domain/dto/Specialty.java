package com.final_project_college.domain.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Specialty extends Entity {

    private String specialtyName;
    private int governmentOrder;
    private boolean sendInvitations;

    @Builder
    private Specialty(long id,String specialtyName,
                      int governmentOrder,
                      boolean sendInvitations) {
        super(id);
        this.specialtyName = specialtyName;
        this.governmentOrder = governmentOrder;
    }
}
