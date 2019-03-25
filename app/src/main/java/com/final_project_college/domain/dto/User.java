package com.final_project_college.domain.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class User extends Entity {

    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private boolean verified;
    private boolean blocked;
    private long roleId;

    @Builder
    private User(long id, String firstName,
                String lastName, String eMail,
                String password, boolean verified,
                boolean blocked, long roleId) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
        this.verified = verified;
        this.blocked = blocked;
        this.roleId = roleId;
    }
}
