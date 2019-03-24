package com.final_project_college.service.impl;

import com.final_project_college.dao.ApplicationDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Application;
import com.final_project_college.exception.SystemException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.service.ApplicationService;
import com.final_project_college.util.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ApplicationServiceImpl extends AbstractService implements ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationDao applicationDao =
                    daoFactory.getApplicationDao(connection);

            return applicationDao.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<Application> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationDao applicationDao =
                    daoFactory.getApplicationDao(connection);

            return applicationDao.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<Application> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationDao applicationDao =
                    daoFactory.getApplicationDao(connection);

            return applicationDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public Application get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationDao applicationDao =
                    daoFactory.getApplicationDao(connection);

            return applicationDao.get(id)
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
            ApplicationDao applicationDao =
                    daoFactory.getApplicationDao(connection);

            if (applicationDao.delete(id))
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
    public Application save(Application entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationDao applicationDao =
                    daoFactory.getApplicationDao(connection);

            return applicationDao.save(ServiceValidator.validateApplication(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public Application update(Application entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicationDao applicationDao =
                    daoFactory.getApplicationDao(connection);

            return applicationDao.update(ServiceValidator.validateApplication(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }
}
