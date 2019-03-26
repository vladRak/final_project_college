package com.final_project_college.service.impl;

import com.final_project_college.dao.ApplicantDao;
import com.final_project_college.dao.ApplicationDao;
import com.final_project_college.dao.SpecialtyDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.domain.dto.Application;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessCode;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.ApplicationService;
import com.final_project_college.util.ApplicationStatusName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import static com.final_project_college.util.ServiceValidator.*;

public class ApplicationServiceImpl extends AbstractService implements ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);


    @Override
    public Application addApplication(Application application, String email) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            ApplicationDao applicationDao = daoFactory.getApplicationDao(connection);
            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);
            ApplicantDao applicantDao = daoFactory.getApplicantDao(connection);

            transactionManager.beginTransaction();

            Applicant applicant = applicantDao
                    .getApplicantByEmail(email)
                    .orElseThrow(() -> new BusinessException(
                            "Invalid session",
                            BusinessCode.UNAUTHORIZED));

            checkApplicationCapacity(
                    checkApplicationExist(
                            applicationDao
                                    .getApplicationsByApplicantId(
                                            applicant.getId()),
                            application.getId()));

            checkPassedExams(
                    applicantDao.getApplicantExams(applicant.getId()),
                    specialtyDao.getEntranceExams(application.getSpecialtyId()));

            application.setApplicantId(applicant.getId());
            application.setStatusId(
                    daoFactory
                            .getApplicationStatusDao(connection)
                            .getByName(ApplicationStatusName.NEW.name())
                            .orElseThrow(() -> new DataAccessException(DataAccessCode.INTERNAL_EXCEPTION))
                            .getId());


            Application created = applicationDao.save(application)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

            transactionManager.commit();

            return created;

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
        throw new BusinessException("Application does not support update", BusinessCode.BAD_REQUEST);
    }
}
