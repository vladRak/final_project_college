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
import java.sql.Statement;
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
        int numOfRows = 0;

        try (PreparedStatement ps = connection
                .prepareStatement(queryManager.getQuery("applicant.count"))) {

            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    numOfRows = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }

        return numOfRows;
    }

    @Override
    public List<Applicant> findAllPaginated(int start, int count) throws DataAccessException {
        List<Applicant> list;

        try (PreparedStatement ps = connection
                .prepareStatement(queryManager.getQuery("applicant.findAllPaginated"))) {
            ps.setInt(1, start);
            ps.setInt(2, count);
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
    public List<Applicant> findAll() throws DataAccessException {
        List<Applicant> list;

        try (PreparedStatement ps = connection.prepareStatement(
                queryManager.getQuery("applicant.findAll"))) {
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
    public Optional<Applicant> getEntityById(long id) throws DataAccessException {
        Optional<Applicant> optional = Optional.empty();

        try (PreparedStatement ps = connection.prepareStatement(
                queryManager.getQuery("applicant.findById"))) {

            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    optional = Optional.ofNullable(processApplicantRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
        return optional;
    }

    @Override
    public boolean deleteById(long id) throws DataAccessException {
        boolean deleted = false;

        try (PreparedStatement ps = connection.prepareStatement(
                queryManager.getQuery("applicant.deleteById"))) {

            ps.setLong(1, id);
            int i = ps.executeUpdate();
            if (i > 0) deleted = true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
        return deleted;
    }

    @Override
    public Applicant create(Applicant entity) throws DataAccessException {
        try (PreparedStatement ps = connection.prepareStatement(
                queryManager.getQuery("applicant.create"),
                Statement.RETURN_GENERATED_KEYS)) {

            setApplicantFieldsToStatement(ps, entity);

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getLong("id"));
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
        return entity;
    }

    @Override
    public Applicant update(Applicant entity) throws DataAccessException {
        try (PreparedStatement ps = connection.prepareStatement(
                queryManager.getQuery("applicant.update"))) {

            setApplicantFieldsToStatement(ps, entity);
            ps.setLong(10, entity.getId());

            if (ps.executeUpdate() == 0) throw new SQLException();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
        return entity;
    }

    private void setApplicantFieldsToStatement(PreparedStatement ps, Applicant applicant) throws SQLException {
        ps.setString(1, applicant.getFirstName());
        ps.setString(2, applicant.getLastName());
        ps.setBoolean(3, applicant.isValid());
        ps.setBytes(4, applicant.getPhoto());
        ps.setString(5, applicant.getPhoneNumber());
        ps.setLong(6, applicant.getUserId());
        ps.setLong(7, applicant.getEIEvaluationId());
        ps.setLong(8, applicant.getCertificateId());
        ps.setLong(9, applicant.getExemptionId());
    }

    private Applicant processApplicantRow(ResultSet rs) throws SQLException {
        return Applicant.builder()
                .id(rs.getLong("applicant.id"))
                .firstName(rs.getString("applicant.first_name"))
                .lastName(rs.getString("applicant.last_name"))
                .valid(rs.getBoolean("applicant.valid"))
                .photo(rs.getBytes("applicant.photo"))
                .phoneNumber(rs.getString("applicant.phone_number"))
                .userId(rs.getLong("applicant.user_id"))
                .eIEvaluationId(rs.getLong("applicant.e_i_evaluation_id"))
                .certificateId(rs.getLong("applicant.certificate_id"))
                .exemptionId(rs.getLong("applicant.exemption_id"))
                .build();
    }
}
