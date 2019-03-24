package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.ApplicantDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Applicant;
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
    public List<Applicant> getApplicantsByName(String name) throws SQLException {
        return null;
    }

    @Override
    public Optional<Applicant> getApplicantBySchoolExamId(long schoolExamId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("applicant.count"));

    }

    @Override
    public List<Applicant> getAllPaginated(int start, int count) throws SQLException {
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
    }

    @Override
    public List<Applicant> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("applicant.findAll"),
                (rs) -> Applicant.builder()
                        .id(rs.getLong("id"))
                        .certificateRating(rs.getBigDecimal("certificate_rating"))
                        .register(rs.getBoolean("register"))
                        .userId(rs.getLong("user_id"))
                        .build());
    }

    @Override
    public Optional<Applicant> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("applicant.findById"),
                (rs) -> Applicant.builder()
                        .id(rs.getLong("id"))
                        .certificateRating(rs.getBigDecimal("certificate_rating"))
                        .register(rs.getBoolean("register"))
                        .userId(rs.getLong("user_id"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {

        return deleteById(id, queryManager
                .getQuery("applicant.deleteById"));

    }

    @Override
    public boolean delete(Applicant entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public Applicant save(Applicant entity) throws SQLException {
        return Applicant.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("applicant.create")))
                .certificateRating(entity.getCertificateRating())
                .register(entity.isRegister())
                .userId(entity.getUserId())
                .build();
    }

    @Override
    public Applicant update(Applicant entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("applicant.update"),
                entity.getCertificateRating(),
                entity.isRegister(),
                entity.getUserId(),
                entity.getId()
        );

        return entity;
    }
}
