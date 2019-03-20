package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EntranceExam extends Entity {

    private short minRating;
    private long examSubjectId;
    private long specialtyId;

    @Builder
    public EntranceExam(long id, short minRating,
                        long examSubjectId,
                        long specialtyId) {
        super(id);
        this.minRating = minRating;
        this.examSubjectId = examSubjectId;
        this.specialtyId = specialtyId;
    }
}
