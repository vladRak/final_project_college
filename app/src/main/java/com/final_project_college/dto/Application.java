package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
public class Application extends Entity {

    private boolean contract;
    private Timestamp created;
    private long applicantId;
    private long collegeId;
    private long specialtyId;
    private long statusId;

    @Builder
    public Application(long id, boolean contract,
                       Timestamp created, long applicantId,
                       long collegeId, long specialtyId,
                       long statusId) {
        super(id);
        this.contract = contract;
        this.created = created;
        this.applicantId = applicantId;
        this.collegeId = collegeId;
        this.specialtyId = specialtyId;
        this.statusId = statusId;
    }
}
