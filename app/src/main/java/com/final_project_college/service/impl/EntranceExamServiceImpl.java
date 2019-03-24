package com.final_project_college.service.impl;

import com.final_project_college.dao.EntranceExamDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.EntranceExam;
import com.final_project_college.exception.SystemException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.service.EntranceExamService;
import com.final_project_college.util.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class EntranceExamServiceImpl extends AbstractService implements EntranceExamService {

    private static final Logger logger = LoggerFactory.getLogger(EntranceExamServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            EntranceExamDao entranceExam = daoFactory.getEntranceExamDao(connection);

            return entranceExam.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<EntranceExam> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            EntranceExamDao entranceExam = daoFactory.getEntranceExamDao(connection);

            return entranceExam.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<EntranceExam> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            EntranceExamDao entranceExam = daoFactory.getEntranceExamDao(connection);

            return entranceExam.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public EntranceExam get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            EntranceExamDao entranceExam = daoFactory.getEntranceExamDao(connection);

            return entranceExam.get(id)
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
            EntranceExamDao entranceExam = daoFactory.getEntranceExamDao(connection);

            if (entranceExam.delete(id))
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
    public EntranceExam save(EntranceExam entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            EntranceExamDao entranceExam = daoFactory.getEntranceExamDao(connection);

            return entranceExam.save(ServiceValidator.validateEntranceExam(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public EntranceExam update(EntranceExam entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            EntranceExamDao entranceExam = daoFactory.getEntranceExamDao(connection);

            return entranceExam.update(ServiceValidator.validateEntranceExam(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }
}
