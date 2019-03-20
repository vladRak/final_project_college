package com.final_project_college.dao;

import com.final_project_college.dto.Privilege;
import com.final_project_college.dto.Role;
import com.final_project_college.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends GenericDAO<User> {

    Optional<User> getByEmail(String email);
    List<User> getUnverifiedUsers();
    Optional<Role> getRoleByUserId(long userId);
    List<Privilege> getPrivilegesByUserId(long userId);
}
