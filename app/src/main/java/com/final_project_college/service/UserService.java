package com.final_project_college.service;

import com.final_project_college.domain.dto.Role;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.SystemException;

public interface UserService extends GenericService<User> {

    User getVerifiedUser(String email, String password) throws SystemException;

    User registerUser(User user);

    User findUserByEmail(String email);

    Role getUserRole(User user) throws SystemException;
}
