package com.final_project_college.service.impl;

import com.final_project_college.dao.SpecialtyDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Specialty;
import com.final_project_college.exception.SystemException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.service.SpecialtyService;
import com.final_project_college.util.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class SpecialtyServiceImpl extends AbstractService implements SpecialtyService {

    private static final Logger logger = LoggerFactory.getLogger(SpecialtyServiceImpl.class);

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);

            return specialtyDao.numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<Specialty> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);

            return specialtyDao.getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public List<Specialty> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);

            return specialtyDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public Specialty get(long id) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);

            return specialtyDao.get(id)
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
            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);

            if (specialtyDao.delete(id))
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
    public Specialty save(Specialty entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);

            return specialtyDao.save(ServiceValidator.validateSpecialty(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }

    @Override
    public Specialty update(Specialty entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {
            SpecialtyDao specialtyDao = daoFactory.getSpecialtyDao(connection);

            return specialtyDao.update(ServiceValidator.validateSpecialty(entity));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.INTERNAL_EXCEPTION);
        }
    }
}
