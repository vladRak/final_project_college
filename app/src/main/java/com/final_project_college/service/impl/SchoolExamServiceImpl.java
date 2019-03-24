package com.final_project_college.service.impl;

import com.final_project_college.dao.SchoolExamDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.SchoolExam;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.service.SchoolExamService;
import com.final_project_college.util.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class SchoolExamServiceImpl extends AbstractService implements SchoolExamService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolExamServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            return schoolExamDao.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<SchoolExam> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            return schoolExamDao.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<SchoolExam> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            return schoolExamDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public SchoolExam get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            return schoolExamDao.get(id)
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
            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            if (schoolExamDao.delete(id))
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
    public SchoolExam save(SchoolExam entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            return schoolExamDao.save(ServiceValidator.validateSchoolExam(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public SchoolExam update(SchoolExam entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            return schoolExamDao.update(ServiceValidator.validateSchoolExam(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }
}
