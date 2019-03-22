package com.final_project_college.dao;

import com.final_project_college.persistence.dto.Privilege;

import java.util.List;
import java.util.Optional;

public interface PrivilegeDao extends GenericDao<Privilege> {

    Optional<Privilege> addRoleToPrivilege(long roleId, long privilegeId);

    Optional<Privilege> removeRoleFromPrivilege(long roleId, long privilegeId);

    Optional<Privilege> getByPrivilegeName(String roleName);

    List<Privilege> getPrivilegesByRoleId(long roleId);

    List<Privilege> getPrivilegesByUserId(long userId);
}
