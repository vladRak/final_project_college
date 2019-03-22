package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SchoolExam extends Entity {

    private short rating;
    private long examSubjectId;
    private long applicantId;

    @Builder
    public SchoolExam(long id, short rating,
                      long examSubjectId,
                      long applicantId) {
        super(id);
        this.rating = rating;
        this.examSubjectId = examSubjectId;
        this.applicantId = applicantId;
    }
}
