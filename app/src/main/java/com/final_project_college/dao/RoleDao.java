package com.final_project_college.dao;

import com.final_project_college.dto.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao extends GenericDao<Role> {

    Optional<Role> addPrivilegeToRole(long privilegeId, long roleId);

    Optional<Role> removePrivilegeFromRole(long privilegeId, long roleId);

    Optional<Role> getByRoleName(String roleName);

    List<Role> getRolesByPrivilegeId(long privilegeId);

    Optional<Role> getRoleByUserId(long userId);
}
