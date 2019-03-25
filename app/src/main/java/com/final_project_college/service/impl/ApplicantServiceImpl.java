package com.final_project_college.service.impl;

import com.final_project_college.dao.UserDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessCode;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.ApplicantService;
import com.final_project_college.util.HashingUtil;
import com.final_project_college.web.filter.WebRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.function.BiFunction;

public class ApplicantServiceImpl extends AbstractService implements ApplicantService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicantServiceImpl.class);

    @Override
    public Applicant registerApplicant(Applicant applicant, User user) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            BiFunction<Applicant, User, Applicant> prepareApplicant = (a, u) -> {
                u.setRoleId(daoFactory
                        .getRoleDao(connection)
                        .getByRoleName(WebRole.APPLICANT.name())
                        .get().getId());

                UserDao userDao = daoFactory.getUserDao(connection);

                a.setUserId(userDao.save(u).get().getId());

                userDao.saveVerificationHash(
                        u.getId(),
                        HashingUtil.hash(
                                new Timestamp(System.currentTimeMillis()).toString()));

                return a;
            };

            transactionManager.beginTransaction();

            Applicant created = daoFactory
                    .getApplicantDao(connection)
                    .save(prepareApplicant.apply(applicant, user))
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
                    .getApplicantDao(connection)
                    .numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public List<Applicant> getAllPaginated(int start, int count) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public List<Applicant> getAll() throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public Applicant get(long id) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
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
                    .getApplicantDao(connection)
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
    public Applicant save(Applicant entity) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .save(entity)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public Applicant update(Applicant entity) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .update(entity)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }
}
