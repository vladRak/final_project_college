package com.final_project_college.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Application extends Entity {

    private boolean contract;
    private Timestamp created;
    private long applicantId;
    private long specialtyId;
    private long statusId;

    @Builder
    private Application(long id, boolean contract,
                        Timestamp created, long applicantId,
                        long specialtyId, long statusId) {
        super(id);
        this.contract = contract;
        this.created = created;
        this.applicantId = applicantId;
        this.specialtyId = specialtyId;
        this.statusId = statusId;
    }
}
