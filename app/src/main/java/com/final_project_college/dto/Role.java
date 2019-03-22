package com.final_project_college.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Role extends Entity {

    private String roleName;

    @Builder
    private Role(long id, String roleName) {
        super(id);
        this.roleName = roleName;
    }
}
