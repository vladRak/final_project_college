package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.ApplicationDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Application;
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
    public List<Application> getApplicationsByApplicantId(long applicantId) throws SQLException {
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
    }

    @Override
    public List<Application> getApplicationsByCollegeId(long collegeId) throws SQLException {
        return null;
    }

    @Override
    public List<Application> getApplicationsBySpecialtyId(long specialtyId) throws SQLException {
        return null;
    }

    @Override
    public List<Application> getApplicationsByStatusId(long statusId) throws SQLException {
        return null;
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("application.count"));


    }

    @Override
    public List<Application> getAllPaginated(int start, int count) throws SQLException {
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
    }

    @Override
    public List<Application> getAll() throws SQLException {
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
    }

    @Override
    public Optional<Application> get(long id) throws SQLException {
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
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("application.delete"));
    }

    @Override
    public boolean delete(Application entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public Application save(Application entity) throws SQLException {
        return Application.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("application.create")))
                .contract(entity.isContract())
                .created(entity.getCreated())
                .applicantId(entity.getApplicantId())
                .collegeId(entity.getCollegeId())
                .specialtyId(entity.getSpecialtyId())
                .statusId(entity.getStatusId())
                .build();
    }

    @Override
    public Application update(Application entity) throws SQLException {
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
    }
}
