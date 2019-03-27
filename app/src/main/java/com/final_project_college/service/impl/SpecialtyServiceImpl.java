package com.final_project_college.service.impl;

import com.final_project_college.dao.SpecialtyDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Application;
import com.final_project_college.domain.dto.Specialty;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessCode;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.SpecialtyService;
import static com.final_project_college.util.ServiceUtil.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class SpecialtyServiceImpl extends AbstractService implements SpecialtyService {

    private static final Logger logger = LoggerFactory.getLogger(SpecialtyServiceImpl.class);

    @Override
    public List<Application> sendInvitations(long specialtyId) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            transactionManager.beginTransaction();

            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);

            Specialty specialty = specialtyDao.get(specialtyId)
                    .orElseThrow(() -> new BusinessException(
                    "Invalid id",
                    BusinessCode.BAD_REQUEST));

            validateSpecialtyInvitation(specialty);

            List<Application> applications = specialtyDao
                    .getApplicationsToSendInvitations(
                            specialtyId,
                            specialty.getGovernmentOrder());

            applications.forEach((a)-> specialtyDao.saveInvitation(a.getId(),specialtyId));

            specialty.setSendInvitations(true);
            specialtyDao.save(specialty);

            List<User> users = daoFactory
                    .getUserDao(connection)
                    .getUsersToInvitation(
                            specialtyId,
                            specialty.getGovernmentOrder());

            transactionManager.commit();

            users.forEach((u)-> sendInvitationMail(u,specialty));

            return applications;

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
                    .getSpecialtyDao(connection)
                    .numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public List<Specialty> getAllPaginated(int start, int count) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSpecialtyDao(connection)
                    .getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public List<Specialty> getAll() throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSpecialtyDao(connection)
                    .getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public Specialty get(long id) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSpecialtyDao(connection)
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
                    .getSpecialtyDao(connection)
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
    public Specialty save(Specialty entity) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSpecialtyDao(connection)
                    .save(entity)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }

    @Override
    public Specialty update(Specialty entity) throws DataAccessException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getSpecialtyDao(connection)
                    .update(entity)
                    .orElseThrow(() -> new DataAccessException(DataAccessCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e, DataAccessCode.TRANSACTION_EXCEPTION);
        }
    }
}
