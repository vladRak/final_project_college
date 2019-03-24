package com.final_project_college.service.impl;

import com.final_project_college.dao.ApplicationStatusDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.ApplicationStatus;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.service.ApplicationStatusService;
import com.final_project_college.util.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ApplicationStatusServiceImpl extends AbstractService implements ApplicationStatusService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStatusServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationStatusDao applicationStatusDao =
                    daoFactory.getApplicationStatusDao(connection);

            return applicationStatusDao.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<ApplicationStatus> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationStatusDao applicationStatusDao =
                    daoFactory.getApplicationStatusDao(connection);

            return applicationStatusDao.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<ApplicationStatus> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationStatusDao applicationStatusDao =
                    daoFactory.getApplicationStatusDao(connection);

            return applicationStatusDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public ApplicationStatus get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationStatusDao applicationStatusDao =
                    daoFactory.getApplicationStatusDao(connection);

            return applicationStatusDao.get(id)
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
            ApplicationStatusDao applicationStatusDao =
                    daoFactory.getApplicationStatusDao(connection);

            if (applicationStatusDao.delete(id))
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
    public ApplicationStatus save(ApplicationStatus entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationStatusDao applicationStatusDao =
                    daoFactory.getApplicationStatusDao(connection);

            return applicationStatusDao.save(ServiceValidator.validateApplicationStatus(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public ApplicationStatus update(ApplicationStatus entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationStatusDao applicationStatusDao =
                    daoFactory.getApplicationStatusDao(connection);

            return applicationStatusDao.update(ServiceValidator.validateApplicationStatus(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }
}
