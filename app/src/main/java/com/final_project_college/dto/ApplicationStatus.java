package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApplicationStatus extends Entity {

    private String statusName;

    @Builder
    public ApplicationStatus(long id, String statusName) {
        super(id);
        this.statusName = statusName;
    }
}
