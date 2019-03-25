package com.final_project_college.domain.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ExamSubject extends Entity {

    private String subjectName;

    @Builder
    private ExamSubject(long id,
                        String subjectName) {
        super(id);
        this.subjectName = subjectName;
    }
}
