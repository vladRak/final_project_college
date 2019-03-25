package com.final_project_college.service;

import com.final_project_college.domain.dto.Role;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.DataAccessException;

public interface UserService extends GenericService<User> {

    User getVerifiedUser(String email, String password) throws DataAccessException;

    User registerUser(User user) throws DataAccessException;

    User findUserByEmail(String email) throws DataAccessException;

    Role getUserRole(User user) throws DataAccessException;
}
