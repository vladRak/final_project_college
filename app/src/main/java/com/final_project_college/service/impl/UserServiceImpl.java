package com.final_project_college.service.impl;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Role;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.exception.SystemException;
import com.final_project_college.service.UserService;
import com.final_project_college.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.final_project_college.util.ServiceValidator.validateUser;

public class UserServiceImpl extends AbstractService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getVerifiedUser(String email, String password) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            Optional<User> user = daoFactory
                    .getUserDao(connection)
                    .getByEmailAndPassword(email, PasswordUtil.hash(password));

            if (user.isPresent()) {
                return user.orElseThrow(() -> new BusinessException(
                        "Please confirm email",
                        BusinessCode.UNCONFIRMED_USER));
            } else throw new BusinessException(
                    "Bad combination login/password",
                    BusinessCode.BAD_LOGIN_PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public Role getUserRole(User user) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getRoleDao(connection)
                    .get(user.getRoleId())
                    .orElseThrow(() -> new BusinessException(
                            "Invalid id",
                            BusinessCode.BAD_REQUEST));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getUserDao(connection)
                    .numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<User> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getUserDao(connection)
                    .getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<User> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getUserDao(connection)
                    .getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public User get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getUserDao(connection)
                    .get(id)
                    .orElseThrow(() -> new BusinessException(
                            "Invalid id",
                            BusinessCode.BAD_REQUEST));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public boolean delete(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            if (daoFactory
                    .getUserDao(connection)
                    .delete(id))
                return true;
            else throw new BusinessException(
                    "Invalid id",
                    BusinessCode.BAD_REQUEST);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public User save(User entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getUserDao(connection)
                    .save(validateUser(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public User update(User entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getUserDao(connection)
                    .update(validateUser(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }
}
