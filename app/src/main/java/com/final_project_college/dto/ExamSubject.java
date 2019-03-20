package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExamSubject extends Entity {

    private String subjectName;

    @Builder
    public ExamSubject(long id,
                       String subjectName) {
        super(id);
        this.subjectName = subjectName;
    }
}
