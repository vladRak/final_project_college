package com.final_project_college.dao;

import com.final_project_college.domain.dto.Privilege;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PrivilegeDao extends GenericDao<Privilege> {

    Optional<Privilege> addRoleToPrivilege(long roleId, long privilegeId) throws SQLException;

    Optional<Privilege> removeRoleFromPrivilege(long roleId, long privilegeId) throws SQLException;

    Optional<Privilege> getByPrivilegeName(String roleName) throws SQLException;

    List<Privilege> getPrivilegesByRoleId(long roleId) throws SQLException;

    List<Privilege> getPrivilegesByUserId(long userId) throws SQLException;
}
