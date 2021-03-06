package com.final_project_college.domain.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class EntranceExam extends Entity {

    private short minRating;
    private long examSubjectId;
    private long specialtyId;

    @Builder
    private EntranceExam(long id, short minRating,
                        long examSubjectId,
                        long specialtyId) {
        super(id);
        this.minRating = minRating;
        this.examSubjectId = examSubjectId;
        this.specialtyId = specialtyId;
    }
}
