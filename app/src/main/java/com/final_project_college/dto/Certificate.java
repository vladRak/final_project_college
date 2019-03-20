package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Certificate extends Entity {

    private String series;
    private int serialNumber;
    private BigDecimal rating;
    private byte[] scan;

    @Builder
    public Certificate(long id, String series,
                        int serialNumber, BigDecimal rating,
                        byte[] scan) {
        super(id);
        this.series = series;
        this.serialNumber = serialNumber;
        this.rating = rating;
        this.scan = scan;
    }
}
