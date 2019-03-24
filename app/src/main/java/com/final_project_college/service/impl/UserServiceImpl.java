package com.final_project_college.service.impl;

import com.final_project_college.dao.RoleDao;
import com.final_project_college.dao.UserDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Role;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.service.UserService;
import com.final_project_college.util.PasswordUtil;
import com.final_project_college.util.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends AbstractService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getVerifiedUser(String email, String password) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            Optional<User> user = userDao
                    .getByEmailAndPassword(email, PasswordUtil.hash(password));

            if (user.isPresent()) {
                return user.orElseThrow(() -> new BusinessException(
                        "Please confirm email",
                        SystemCode.UNCONFIRMED_USER));
            } else throw new BusinessException(
                    "Bad combination login/password",
                    SystemCode.BAD_LOGIN_PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
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
            RoleDao roleDao = daoFactory.getRoleDao(connection);

            return roleDao.get(user.getRoleId())
                    .orElseThrow(() -> new BusinessException(
                            "Invalid id",
                            SystemCode.BAD_REQUEST));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            return userDao.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<User> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            return userDao.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<User> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            return userDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public User get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            return userDao.get(id)
                    .orElseThrow(() -> new BusinessException(
                            "Invalid id",
                            SystemCode.BAD_REQUEST));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public boolean delete(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            if (userDao.delete(id))
                return true;
            else throw new BusinessException(
                    "Invalid id",
                    SystemCode.BAD_REQUEST);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public User save(User entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            return userDao.save(ServiceValidator.validateUser(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public User update(User entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);

            return userDao.update(ServiceValidator.validateUser(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }
}
