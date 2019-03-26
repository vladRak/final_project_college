package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.ApplicationDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlApplicationDao extends MySqlAbstractDao implements ApplicationDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlApplicationDao.class);

    public MySqlApplicationDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<Application> getApplicationsByApplicantEmail(String email) {
        try {
            return queryManager.select(
                    queryManager.getQuery("application.findApplicationsByApplicantEmail"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build(),
                    email
            );
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Application> getApplicationsByApplicantId(long applicantId) {
        try {
            return queryManager.select(
                    queryManager.getQuery("application.findApplicationsByApplicantId"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build(),
                    applicantId
            );
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
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
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("application.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Application> getAllPaginated(int start, int count) {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAllPaginated"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build(),
                    start,
                    count
            );
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Application> getAll() {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAll"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Application> get(long id) {
        try {
            return queryManager.select(
                    queryManager.getQuery("application.findById"),
                    (rs) -> Application.builder()
                            .id(rs.getLong("id"))
                            .created(rs.getTimestamp("created"))
                            .applicantId(rs.getLong("applicant_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .statusId(rs.getLong("status_id"))
                            .build(),
                    id).stream().findFirst();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            return deleteById(id, queryManager
                    .getQuery("application.delete"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Application entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<Application> save(Application entity) {
        try {

            entity.setId(
                    queryManager.insertAndGetId(
                            queryManager.getQuery("application.create"),
                            entity.getCreated(),
                            entity.getApplicantId(),
                            entity.getSpecialtyId(),
                            entity.getStatusId()
                    ));

            return Optional.of(entity);

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Application> update(Application entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("application.update"),
                    entity.getCreated(),
                    entity.getApplicantId(),
                    entity.getSpecialtyId(),
                    entity.getStatusId(),
                    entity.getId()
            );
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
