package com.final_project_college.service.impl;

import com.final_project_college.dao.SchoolExamDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.SchoolExam;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessCode;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.SchoolExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class SchoolExamServiceImpl extends AbstractService implements SchoolExamService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolExamServiceImpl.class);

    @Override
    public SchoolExam updateSchoolExam(SchoolExam exam, String email) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            transactionManager.beginTransaction();

            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            SchoolExam schoolExam = schoolExamDao
                    .update(schoolExamDao
                            .getSchoolExamByEmail(email)
                            .orElseThrow(() -> new BusinessException(
                                    "Invalid id",
                                    BusinessCode.BAD_REQUEST))).get();

            transactionManager.commit();

            return schoolExam;
        } catch (SQLException e) {
            try {
                transactionManager.rollback();
            } catch (SQLException e1) {
                logger.error(e.getMessage());
                throw new DataAccessException(e1, DataAccessCode.TRANSACTION_EXCEPTION);
            }
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public boolean deleteSchoolExam(long schoolExamId, String email) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            transactionManager.beginTransaction();

            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            boolean deleted = schoolExamDao
                    .delete(schoolExamDao
                            .getSchoolExamByEmail(email)
                            .orElseThrow(() -> new BusinessException(
                                    "Invalid id",
                                    BusinessCode.BAD_REQUEST)).getId());

            transactionManager.commit();

            return deleted;
        } catch (SQLException e) {
            try {
                transactionManager.rollback();
            } catch (SQLException e1) {
                logger.error(e.getMessage());
                throw new DataAccessException(e1, DataAccessCode.TRANSACTION_EXCEPTION);
            }
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public SchoolExam addSchoolExam(SchoolExam schoolExam, String email) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            schoolExam.setApplicantId(
                    daoFactory
                            .getUserDao(connection)
                            .getByEmail(email)
                            .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION))
                            .getId());
            return daoFactory
                    .getSchoolExamDao(connection)
                    .save(schoolExam)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public int numberOfRows() throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSchoolExamDao(connection)
                    .numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public List<SchoolExam> getAllPaginated(int start, int count) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSchoolExamDao(connection)
                    .getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public List<SchoolExam> getAll() throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSchoolExamDao(connection)
                    .getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public SchoolExam get(long id) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSchoolExamDao(connection)
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
                    .getSchoolExamDao(connection)
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
    public SchoolExam save(SchoolExam entity) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSchoolExamDao(connection)
                    .save(entity)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public SchoolExam update(SchoolExam entity) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSchoolExamDao(connection)
                    .update(entity)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }
}
