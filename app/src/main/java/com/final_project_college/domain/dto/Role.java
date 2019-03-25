package com.final_project_college.domain.dto;

import lombok.*;

@Getter
@Setter
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
