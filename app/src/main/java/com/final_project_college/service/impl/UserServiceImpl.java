package com.final_project_college.service.impl;

import com.final_project_college.dao.UserDao;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.exception.InvalidInputDataException;
import com.final_project_college.exception.VerificationException;
import com.final_project_college.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends AbstractService implements UserService {
    @Override
    public User getVerifiedUser(String email, String password) throws VerificationException, DataAccessException {
        return null;
    }

    @Override
    public User registerUser(User user) throws DataAccessException, InvalidInputDataException {
        return null;
    }

    @Override
    public User findUserByEmail(String email) throws InvalidInputDataException, DataAccessException {
        return null;
    }

    @Override
    public int numberOfRows() {
        return 0;
    }

    @Override
    public List<User> getAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
