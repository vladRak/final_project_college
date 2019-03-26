package com.final_project_college.domain.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Application extends Entity {

    private Timestamp created;
    private long applicantId;
    private long specialtyId;
    private long statusId;

    @Builder
    private Application(long id,
                        Timestamp created, long applicantId,
                        long specialtyId, long statusId) {
        super(id);
        this.created = created;
        this.applicantId = applicantId;
        this.specialtyId = specialtyId;
        this.statusId = statusId;
    }
}
