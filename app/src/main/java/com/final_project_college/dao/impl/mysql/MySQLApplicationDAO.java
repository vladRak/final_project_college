package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.ApplicationDAO;
import com.final_project_college.dto.Application;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySQLApplicationDAO extends MySQLAbstractDAO implements ApplicationDAO {

    private static final Logger logger = LoggerFactory.getLogger(MySQLApplicationDAO.class);

    public MySQLApplicationDAO(ConnectionWrapper connection) {
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
                            .active(rs.getBoolean("active"))
                            .contract(rs.getBoolean("contract"))
                            .priority(rs.getByte("priority"))
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
                            .active(rs.getBoolean("active"))
                            .contract(rs.getBoolean("contract"))
                            .priority(rs.getByte("priority"))
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
                            .active(rs.getBoolean("active"))
                            .contract(rs.getBoolean("contract"))
                            .priority(rs.getByte("priority"))
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
                            .active(rs.getBoolean("active"))
                            .contract(rs.getBoolean("contract"))
                            .priority(rs.getByte("priority"))
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
                    entity.isActive(),
                    entity.isContract(),
                    entity.getPriority(),
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
                    entity.isActive(),
                    entity.isContract(),
                    entity.getPriority(),
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
