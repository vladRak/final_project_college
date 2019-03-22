package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.ApplicationDao;
import com.final_project_college.persistence.dto.Application;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlApplicationDao extends MySqlAbstractDao implements ApplicationDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlApplicationDao.class);

    public MySqlApplicationDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<Application> getApplicationsByApplicantId(long applicantId)
            throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("application.findApplicationsByApplicantId"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .contract(rs.getBoolean("contract"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .collegeId(rs.getLong("college_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build(),
                    applicantId
            );
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Application> getApplicationsByCollegeId(long collegeId) {
        return null;
    }

    @Override
    public List<Application> getApplicationsBySpecialtyId(long specialtyId) {
        return null;
    }

    @Override
    public List<Application> getApplicationsByStatusId(long statusId) {
        return null;
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {

            return getNumberOfRows(queryManager
                    .getQuery("application.count"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Application> findAllPaginated(int start, int count)
            throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAllPaginated"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .contract(rs.getBoolean("contract"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .collegeId(rs.getLong("college_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build(),
                    start,
                    count
            );
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Application> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAll"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .contract(rs.getBoolean("contract"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .collegeId(rs.getLong("college_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<Application> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("application.findById"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .contract(rs.getBoolean("contract"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .collegeId(rs.getLong("college_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build(),
                    id).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws DataAccessException {
        try {

            return deleteById(id, queryManager
                    .getQuery("application.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Application create(Application entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("application.create"),
                    entity.isContract(),
                    entity.getCreated(),
                    entity.getApplicantId(),
                    entity.getCollegeId(),
                    entity.getSpecialtyId(),
                    entity.getStatusId()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Application update(Application entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("application.update"),
                    entity.isContract(),
                    entity.getCreated(),
                    entity.getApplicantId(),
                    entity.getCollegeId(),
                    entity.getSpecialtyId(),
                    entity.getStatusId(),
                    entity.getId()
            );

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }
}
