package com.final_project_college.service.impl;

import com.final_project_college.dao.ApplicantDao;
import com.final_project_college.dao.SchoolExamDao;
import com.final_project_college.dao.UserDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.domain.dto.SchoolExam;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemCode;
import com.final_project_college.exception.SystemException;
import com.final_project_college.service.ApplicantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import static com.final_project_college.util.ServiceValidator.validateApplicant;
import static com.final_project_college.util.ServiceValidator.validateSchoolExam;

public class ApplicantServiceImpl extends AbstractService implements ApplicantService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicantServiceImpl.class);

    @Override
    public Applicant registerApplicant(Applicant applicant, List<SchoolExam> schoolExams, User user) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            validateApplicant(applicant);
            schoolExams.forEach((se) -> validateSchoolExam(se));

            UserDao userDao = daoFactory.getUserDao(connection);
            ApplicantDao applicantDao = daoFactory.getApplicantDao(connection);
            SchoolExamDao schoolExamDao = daoFactory.getSchoolExamDao(connection);

            daoFactory
                    .getApplicantDao(connection)
                    .save((a) -> {
                        a
                    })
                    .setUserId(daoFactory
                            .getUserDao(connection)
                            .save(user).getId()));

//            daoFactory
//                    .getApplicantDao(connection)
//                    .save(applicant
//                            .setUserId(daoFactory
//                                    .getUserDao(connection)
//                                    .save(user).getId()));


            return applicantDao.save(validateApplicant(applicant));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public int numberOfRows() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .numberOfRows();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<Applicant> getAllPaginated(int start, int count) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .getAllPaginated(start, count);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<Applicant> getAll() throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .getAll();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public Applicant get(long id) throws SystemException {
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
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public boolean delete(long id) throws SystemException {
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
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public Applicant save(Applicant entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .save(validateApplicant(entity))
                    .orElseThrow(() -> new SystemException(SystemCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }

    @Override
    public Applicant update(Applicant entity) throws SystemException {
        try (ConnectionWrapper connection = transactionManager.getConnection()) {

            return daoFactory
                    .getApplicantDao(connection)
                    .update(validateApplicant(entity))
                    .orElseThrow(() -> new SystemException(SystemCode.SQL_EXCEPTION));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemException(e, SystemCode.SQL_EXCEPTION);
        }
    }
}
