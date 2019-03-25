package com.final_project_college.domain.dto;

import lombok.*;

@Getter
@Setter
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
