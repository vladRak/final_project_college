package com.final_project_college.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Applicant extends Entity {

    private BigDecimal certificateRating;
    private long userId;

    @Builder
    private Applicant(long id,
                     BigDecimal certificateRating,
                     long userId) {
        super(id);
        this.certificateRating = certificateRating;
        this.userId = userId;
    }
}
