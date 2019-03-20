package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Applicant extends Entity {

    private String firstName;
    private String lastName;
    private boolean valid;
    private byte[] photo;
    private String phoneNumber;
    private long userId;
    private long eIEvaluationId;
    private long certificateId;
    private long exemptionId;

    @Builder
    public Applicant(long id, String firstName,
                     String lastName, boolean valid,
                     byte[] photo, String phoneNumber,
                     long userId, long eIEvaluationId,
                     long certificateId, long exemptionId) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.valid = valid;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.eIEvaluationId = eIEvaluationId;
        this.certificateId = certificateId;
        this.exemptionId = exemptionId;
    }
}
