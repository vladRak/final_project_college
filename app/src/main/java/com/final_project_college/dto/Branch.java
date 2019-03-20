package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Branch extends CoefficientTarget {

    private short branchCode;
    private String branchName;

    @Builder
    public Branch(long id, short branchCode,
                  BigDecimal branchCoefficient,
                  String branchName) {
        super(id, branchCoefficient);
        this.branchCode = branchCode;
        this.branchName = branchName;
    }
}
