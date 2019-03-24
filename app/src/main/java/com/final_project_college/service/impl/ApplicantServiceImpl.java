package com.final_project_college.service.impl;

import com.final_project_college.dao.ApplicantDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.exception.SystemException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.service.ApplicantService;
import com.final_project_college.util.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ApplicantServiceImpl extends AbstractService implements ApplicantService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicantServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicantDao ApplicantDao =
                    daoFactory.getApplicantDao(connection);

            return ApplicantDao.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<Applicant> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicantDao ApplicantDao =
                    daoFactory.getApplicantDao(connection);

            return ApplicantDao.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<Applicant> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicantDao ApplicantDao =
                    daoFactory.getApplicantDao(connection);

            return ApplicantDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public Applicant get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicantDao ApplicantDao =
                    daoFactory.getApplicantDao(connection);

            return ApplicantDao.get(id)
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
            ApplicantDao ApplicantDao =
                    daoFactory.getApplicantDao(connection);

            if (ApplicantDao.delete(id))
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
    public Applicant save(Applicant entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicantDao ApplicantDao =
                    daoFactory.getApplicantDao(connection);

            return ApplicantDao.save(ServiceValidator.validateApplicant(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public Applicant update(Applicant entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            ApplicantDao ApplicantDao =
                    daoFactory.getApplicantDao(connection);

            return ApplicantDao.update(ServiceValidator.validateApplicant(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }
}
