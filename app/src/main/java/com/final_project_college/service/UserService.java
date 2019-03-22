package com.final_project_college.service;

import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.exception.InvalidInputDataException;
import com.final_project_college.exception.VerificationException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends GenericService<User>{

    User getVerifiedUser(String email, String password) throws VerificationException, DataAccessException;

    User registerUser(User user) throws DataAccessException, InvalidInputDataException;

    User findUserByEmail(String email) throws InvalidInputDataException, DataAccessException;
}
