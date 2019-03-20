package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Region extends CoefficientTarget{

    private String regionName;

    @Builder
    public Region(long id, String regionName,
                  BigDecimal regionCoefficient) {
        super(id, regionCoefficient);
        this.regionName = regionName;
    }
}
