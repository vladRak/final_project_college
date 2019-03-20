package com.final_project_college.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Entity {

    private String eMail;
    private String password;
    private boolean verified;
    private boolean blocked;
    private long roleId;

    @Builder
    public User(long id, String eMail,
                String password, boolean verified,
                boolean blocked, long roleId) {
        super(id);
        this.eMail = eMail;
        this.password = password;
        this.verified = verified;
        this.blocked = blocked;
        this.roleId = roleId;
    }
}
