package com.final_project_college.dao;

import com.final_project_college.domain.dto.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    Optional<User> getByEmail(String email) throws SQLException;

    Optional<User> getByEmailAndPassword(String email, String password) throws SQLException;

    List<User> getUnverifiedUsers() throws SQLException;

    List<User> getUsersByRoleId(long roleId) throws SQLException;

    List<User> getUnverifiedUsersByRoleId(long roleId) throws SQLException;
}
