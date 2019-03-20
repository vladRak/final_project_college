package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EIEvaluation extends Entity {
//    ExternalIndependentEvaluation

    private int year;
    private int serialNumber;
    private int pin;
    private byte[] scan;

    @Builder
    public EIEvaluation(long id, int year,
                        int serialNumber, int pin,
                        byte[] scan) {
        super(id);
        this.year = year;
        this.serialNumber = serialNumber;
        this.pin = pin;
        this.scan = scan;
    }
}
