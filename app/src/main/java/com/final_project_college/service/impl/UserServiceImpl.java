package com.final_project_college.service.impl;

import com.final_project_college.dao.UserDao;
import com.final_project_college.dao.impl.mysql.MySqlApplicantDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.ExceptionCode;
import com.final_project_college.exception.InvalidInputDataException;
import com.final_project_college.exception.VerificationException;
import com.final_project_college.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends AbstractService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(MySqlApplicantDao.class);

    @Override
    public User getVerifiedUser(String email, String password) throws VerificationException {
        return null;
    }

    @Override
    public User registerUser(User user) throws InvalidInputDataException {
        return null;
    }

    @Override
    public User findUserByEmail(String email) throws InvalidInputDataException {
        return null;
    }

    @Override
    public int numberOfRows() throws BusinessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            return userDao.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new BusinessException(e, ExceptionCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<User> getAllPaginated(int start, int count) throws BusinessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            return userDao.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new BusinessException(e, ExceptionCode.INTERNAL_EXCEPTION);
        }
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
