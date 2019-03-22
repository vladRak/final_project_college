package com.final_project_college.persistence.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ApplicationStatus extends Entity {

    private String statusName;

    @Builder
    private ApplicationStatus(long id, String statusName) {
        super(id);
        this.statusName = statusName;
    }
}
