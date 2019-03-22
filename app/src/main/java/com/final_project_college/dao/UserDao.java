package com.final_project_college.dao;

import com.final_project_college.persistence.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    Optional<User> getByEmail(String email);

    List<User> getUnverifiedUsers();

    List<User> getUsersByPrivilegeId(long privilegeId);

    List<User> getUnverifiedUsersByPrivilegeId(long privilegeId);

    List<User> getUsersByRoleId(long roleId);

    List<User> getUnverifiedUsersByRoleId(long roleId);

}
