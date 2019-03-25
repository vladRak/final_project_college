package com.final_project_college.service.impl;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Application;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessCode;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ApplicationServiceImpl extends AbstractService implements ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Override
    public int numberOfRows() throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationDao(connection)
                    .numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public List<Application> getAllPaginated(int start, int count) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationDao(connection)
                    .getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public List<Application> getAll() throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationDao(connection)
                    .getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public Application get(long id) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationDao(connection)
                    .get(id)
                    .orElseThrow(() -> new BusinessException(
                            "Invalid id",
                            BusinessCode.BAD_REQUEST));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public boolean delete(long id) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            if (daoFactory
                    .getApplicationDao(connection)
                    .delete(id))
                return true;
            else throw new BusinessException(
                    "Invalid id",
                    BusinessCode.BAD_REQUEST);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public Application save(Application entity) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationDao(connection)
                    .save(entity)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public Application update(Application entity) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicationDao(connection)
                    .update(entity)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }
}
