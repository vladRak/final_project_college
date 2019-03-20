package com.final_project_college.dao;

import com.final_project_college.dto.Privilege;
import com.final_project_college.dto.Role;
import com.final_project_college.dto.User;

import java.util.List;
import java.util.Optional;

public interface PrivilegeDAO extends GenericDAO<Privilege> {

    Optional<Privilege> addRoleToPrivilege(long roleId, long privilegeId);
    Optional<Privilege> removeRoleFromPrivilege(long roleId, long privilegeId);
    Optional<Privilege> getByPrivilegeName(String roleName);
    List<Role> getRolesByPrivilegeId(long privilegeId);
    List<User> getUsersByPrivilegeId(long privilegeId);
    List<User> getUnverifiedUsersByPrivilegeId(long privilegeId);
}
