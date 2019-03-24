package com.final_project_college.service.impl;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.ApplicationStatus;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.exception.SystemException;
import com.final_project_college.service.ApplicationStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import static com.final_project_college.util.ServiceValidator.validateApplicationStatus;

public class ApplicationStatusServiceImpl extends AbstractService implements ApplicationStatusService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStatusServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationStatusDao(connection)
                    .numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<ApplicationStatus> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationStatusDao(connection)
                    .getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<ApplicationStatus> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationStatusDao(connection)
                    .getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public ApplicationStatus get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationStatusDao(connection)
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
                    .getApplicationStatusDao(connection)
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
    public ApplicationStatus save(ApplicationStatus entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationStatusDao(connection)
                    .save(validateApplicationStatus(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public ApplicationStatus update(ApplicationStatus entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationStatusDao(connection)
                    .update(validateApplicationStatus(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }
}
