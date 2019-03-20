package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends Entity {

    private String roleName;

    @Builder
    public Role(long id, String roleName) {
        super(id);
        this.roleName = roleName;
    }
}
