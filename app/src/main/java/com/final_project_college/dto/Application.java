package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
public class Application extends Entity {

    private boolean active;
    private boolean contract;
    private byte priority;
    private Timestamp created;
    private long applicantId;
    private long collegeId;
    private long specialtyId;
    private long statusId;

    @Builder
    public Application(long id, boolean active,
                       boolean contract, byte priority,
                       Timestamp created, long applicantId,
                       long collegeId, long specialtyId,
                       long statusId) {
        super(id);
        this.active = active;
        this.contract = contract;
        this.priority = priority;
        this.created = created;
        this.applicantId = applicantId;
        this.collegeId = collegeId;
        this.specialtyId = specialtyId;
        this.statusId = statusId;
    }
}
