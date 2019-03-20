package com.final_project_college.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class CoefficientTarget extends Entity {

    private BigDecimal coefficient;

    public CoefficientTarget(long id,
                             BigDecimal coefficient) {
        super(id);
        this.coefficient = coefficient;
    }
}
