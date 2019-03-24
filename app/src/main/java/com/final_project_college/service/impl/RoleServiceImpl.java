package com.final_project_college.service.impl;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Role;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.exception.SystemException;
import com.final_project_college.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import static com.final_project_college.util.ServiceValidator.validateRole;

public class RoleServiceImpl extends AbstractService implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getRoleDao(connection)
                    .numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<Role> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getRoleDao(connection)
                    .getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<Role> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getRoleDao(connection)
                    .getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public Role get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getRoleDao(connection)
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
                    .getRoleDao(connection)
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
    public Role save(Role entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getRoleDao(connection)
                    .save(validateRole(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public Role update(Role entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getRoleDao(connection)
                    .update(validateRole(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }
}
