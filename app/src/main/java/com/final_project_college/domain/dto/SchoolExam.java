package com.final_project_college.domain.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class SchoolExam extends Entity {

    private short rating;
    private long examSubjectId;
    private long applicantId;

    @Builder
    private SchoolExam(long id, short rating,
                      long examSubjectId,
                      long applicantId) {
        super(id);
        this.rating = rating;
        this.examSubjectId = examSubjectId;
        this.applicantId = applicantId;
    }
}
