package com.final_project_college.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Applicant extends Entity {

    private BigDecimal certificateRating;
    private boolean register;
    private long userId;

    @Builder
    private Applicant(long id,
                      BigDecimal certificateRating,
                      boolean register, long userId) {
        super(id);
        this.certificateRating = certificateRating;
        this.register = register;
        this.userId = userId;
    }
}
