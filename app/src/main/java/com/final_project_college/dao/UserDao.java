package com.final_project_college.dao;

import com.final_project_college.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    Optional<User> getByEmail(String email);

    Optional<User> getByEmailAndPassword(String email, String password);

    List<User> getUnverifiedUsers();

    List<User> getUsersByRoleId(long roleId);

    List<User> getUnverifiedUsersByRoleId(long roleId);
}
