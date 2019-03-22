package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.ApplicantDao;
import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlApplicantDao extends MySqlAbstractDao implements ApplicantDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlApplicantDao.class);

    public MySqlApplicantDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<Applicant> getApplicantsByName(String name) {
        return null;
    }

    @Override
    public List<Applicant> getApplicantsByCollegeId(long collegeId) {
        return null;
    }

    @Override
    public Optional<Applicant> getApplicantBySchoolExamId(long schoolExamId) {
        return Optional.empty();
    }

    @Override
    public int numberOfRows() {
        try {

            return getNumberOfRows(queryManager
                    .getQuery("applicant.count"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Applicant> getAllPaginated(int start, int count) {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAllPaginated"),
                    (rs) -> Applicant.builder()
                            .id(rs.getLong("id"))
                            .certificateRating(rs.getBigDecimal("certificate_rating"))
                            .userId(rs.getLong("user_id"))
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
    public List<Applicant> getAll() {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAll"),
                    (rs) -> Applicant.builder()
                            .id(rs.getLong("id"))
                            .certificateRating(rs.getBigDecimal("certificate_rating"))
                            .userId(rs.getLong("user_id"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<Applicant> get(long id) {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findById"),
                    (rs) -> Applicant.builder()
                            .id(rs.getLong("id"))
                            .certificateRating(rs.getBigDecimal("certificate_rating"))
                            .userId(rs.getLong("user_id"))
                            .build(),
                    id).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean delete(long id) {
        try {

            return deleteById(id, queryManager
                    .getQuery("applicant.deleteById"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Applicant entity) {
        return delete(entity.getId());
    }

    @Override
    public Applicant save(Applicant entity) {
        try {
            return Applicant.builder()
                    .id(queryManager.insertAndGetId(
                            queryManager.getQuery("applicant.create")))
                    .certificateRating(entity.getCertificateRating())
                    .userId(entity.getUserId())
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Applicant update(Applicant entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("applicant.update"),
                    entity.getCertificateRating(),
                    entity.getUserId(),
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
