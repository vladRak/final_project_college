package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.ApplicantDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Applicant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

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
    public Optional<Applicant> getApplicantBySchoolExamId(long schoolExamId) {
        return Optional.empty();
    }

    @Override
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("applicant.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
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
                            .register(rs.getBoolean("register"))
                            .userId(rs.getLong("user_id"))
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
    public List<Applicant> getAll() {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAll"),
                    (rs) -> Applicant.builder()
                            .id(rs.getLong("id"))
                            .certificateRating(rs.getBigDecimal("certificate_rating"))
                            .register(rs.getBoolean("register"))
                            .userId(rs.getLong("user_id"))
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
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
                            .register(rs.getBoolean("register"))
                            .userId(rs.getLong("user_id"))
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
                    .getQuery("applicant.deleteById"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Applicant entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<Applicant> save(Applicant entity) {
        try {
            return Optional.of(
                    Applicant.builder()
                            .id(queryManager.insertAndGetId(
                                    queryManager.getQuery("applicant.create")))
                            .certificateRating(entity.getCertificateRating())
                            .register(entity.isRegister())
                            .userId(entity.getUserId())
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Applicant> update(Applicant entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("applicant.update"),
                    entity.getCertificateRating(),
                    entity.isRegister(),
                    entity.getUserId(),
                    entity.getId()
            );

            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
