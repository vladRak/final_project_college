package com.final_project_college.dao;

import com.final_project_college.domain.dto.Role;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface RoleDao extends GenericDao<Role> {

    Optional<Role> getByRoleName(String roleName) throws SQLException;

    Optional<Role> getRoleByUserId(long userId) throws SQLException;
}
