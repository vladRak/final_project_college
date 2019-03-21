package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.ApplicantDAO;
import com.final_project_college.dto.Applicant;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLApplicantDAO extends MySQLAbstractDAO implements ApplicantDAO {

    private static final Logger logger = LoggerFactory.getLogger(MySQLApplicantDAO.class);

    public MySQLApplicantDAO(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<Applicant> getApplicantsByName(String name) throws DataAccessException {
        List<Applicant> list;

        try (PreparedStatement ps = connection
                .prepareStatement(queryManager.getQuery("applicant.findApplicantsByName"))) {
            ps.setString(1, name);
            ps.setString(2, name);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processApplicantRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
        return list;
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
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
    public List<Applicant> findAllPaginated(int start, int count) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAllPaginated"),
                    (rs) -> Applicant.builder()
                            .id(rs.getLong("id"))
                            .firstName(rs.getString("first_name"))
                            .lastName(rs.getString("last_name"))
                            .valid(rs.getBoolean("valid"))
                            .photo(rs.getBytes("photo"))
                            .phoneNumber(rs.getString("phone_number"))
                            .userId(rs.getLong("user_id"))
                            .eIEvaluationId(rs.getLong("e_i_evaluation_id"))
                            .certificateId(rs.getLong("certificate_id"))
                            .exemptionId(rs.getLong("exemption_id"))
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
    public List<Applicant> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findAll"),
                    (rs) -> Applicant.builder()
                            .id(rs.getLong("id"))
                            .firstName(rs.getString("first_name"))
                            .lastName(rs.getString("last_name"))
                            .valid(rs.getBoolean("valid"))
                            .photo(rs.getBytes("photo"))
                            .phoneNumber(rs.getString("phone_number"))
                            .userId(rs.getLong("user_id"))
                            .eIEvaluationId(rs.getLong("e_i_evaluation_id"))
                            .certificateId(rs.getLong("certificate_id"))
                            .exemptionId(rs.getLong("exemption_id"))
                            .build();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<Applicant> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("applicant.findById"),
                    (rs) -> Applicant.builder()
                            .id(rs.getLong("id"))
                            .firstName(rs.getString("first_name"))
                            .lastName(rs.getString("last_name"))
                            .valid(rs.getBoolean("valid"))
                            .photo(rs.getBytes("photo"))
                            .phoneNumber(rs.getString("phone_number"))
                            .userId(rs.getLong("user_id"))
                            .eIEvaluationId(rs.getLong("e_i_evaluation_id"))
                            .certificateId(rs.getLong("certificate_id"))
                            .exemptionId(rs.getLong("exemption_id"))
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
                    .getQuery("applicant.deleteById"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Applicant create(Applicant entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("applicant.create"),
                    entity.getFirstName(),
                    entity.getLastName(),
                    entity.isValid(),
                    entity.getPhoto(),
                    entity.getPhoneNumber(),
                    entity.getUserId(),
                    entity.getEIEvaluationId(),
                    entity.getCertificateId(),
                    entity.getExemptionId()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Applicant update(Applicant entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("applicant.update"),
                    entity.getFirstName(),
                    entity.getLastName(),
                    entity.isValid(),
                    entity.getPhoto(),
                    entity.getPhoneNumber(),
                    entity.getUserId(),
                    entity.getEIEvaluationId(),
                    entity.getCertificateId(),
                    entity.getExemptionId(),
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
