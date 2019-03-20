package com.final_project_college.dao;

import com.final_project_college.dto.Privilege;
import com.final_project_college.dto.Role;
import com.final_project_college.dto.User;

import java.util.List;
import java.util.Optional;

public interface RoleDAO extends GenericDAO<Role> {

    Optional<Role> addPrivilegeToRole(long privilegeId, long roleId);
    Optional<Role> removePrivilegeFromRole(long privilegeId, long roleId);
    Optional<Role> getByRoleName(String roleName);
    List<User> getUsersByRoleId(long roleId);
    List<User> getUnverifiedUsersByRoleId(long roleId);
    List<Privilege> getPrivilegesByRoleId(long roleId);
}
