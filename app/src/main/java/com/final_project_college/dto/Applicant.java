package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Applicant extends Entity {

    private BigDecimal certificateRating;
    private long userId;

    @Builder
    public Applicant(long id,
                     BigDecimal certificateRating,
                     long userId) {
        super(id);
        this.certificateRating = certificateRating;
        this.userId = userId;
    }
}
