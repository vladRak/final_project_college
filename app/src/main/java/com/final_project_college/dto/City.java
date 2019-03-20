package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class City extends CoefficientTarget {

    private String cityName;
    private long regionId;

    @Builder
    public City(long id, String cityName,
                BigDecimal cityCoefficient,
                long regionId) {
        super(id, cityCoefficient);
        this.cityName = cityName;
        this.regionId = regionId;
    }
}
