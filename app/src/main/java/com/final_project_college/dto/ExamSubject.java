package com.final_project_college.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
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
