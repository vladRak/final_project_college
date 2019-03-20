package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Exemption extends Entity {

    private boolean valid;
    private byte[] scan;

    @Builder
    public Exemption(long id, boolean valid,
                     byte[] scan) {
        super(id);
        this.valid = valid;
        this.scan = scan;
    }
}
