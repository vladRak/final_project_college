package com.final_project_college.service.impl;

import com.final_project_college.dao.RoleDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Role;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.service.RoleService;
import com.final_project_college.util.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl extends AbstractService implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            RoleDao roleDao = daoFactory.getRoleDao(connection);

            return roleDao.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<Role> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            RoleDao roleDao = daoFactory.getRoleDao(connection);

            return roleDao.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<Role> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            RoleDao roleDao = daoFactory.getRoleDao(connection);

            return roleDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public Role get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            RoleDao roleDao = daoFactory.getRoleDao(connection);

            return roleDao.get(id)
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
            RoleDao roleDao = daoFactory.getRoleDao(connection);

            if (roleDao.delete(id))
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
    public Role save(Role entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            RoleDao roleDao = daoFactory.getRoleDao(connection);

            return roleDao.save(ServiceValidator.validateRole(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public Role update(Role entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            RoleDao roleDao = daoFactory.getRoleDao(connection);

            return roleDao.update(ServiceValidator.validateRole(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }
}
