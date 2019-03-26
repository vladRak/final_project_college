package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.SpecialtyDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.EntranceExam;
import com.final_project_college.domain.dto.Specialty;
import com.final_project_college.domain.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlSpecialtyDao extends MySqlAbstractDao implements SpecialtyDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlSpecialtyDao.class);

    public MySqlSpecialtyDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public boolean saveInvitation(long applicationId, long specialtyId) {
        try {
            return -1 < queryManager.insertAndGetId(
                    queryManager.getQuery("specialty.saveInvitation"),
                    applicationId,
                    specialtyId
            );
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<User> getUsersToSendInvitations(long specialtyId, int governmentOrder) {
        try {
            return queryManager.select(
                    queryManager.getQuery("specialty.getUsersToInvitation"),
                    (rs) -> User.builder()
                            .id(rs.getLong("id"))
                            .firstName(rs.getString("first_name"))
                            .lastName(rs.getString("last_name"))
                            .eMail(rs.getString("e_mail"))
                            .build(),
                    specialtyId,
                    governmentOrder
            );
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<EntranceExam> getEntranceExams(long specialtyId) {
        try {
            return queryManager.select(
                    queryManager.getQuery("specialty.findAllPaginated"),
                    (rs) -> EntranceExam.builder()
                            .id(rs.getLong("id"))
                            .minRating(rs.getShort("min_rating"))
                            .examSubjectId(rs.getLong("exam_subject_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .build(),
                    specialtyId
            );
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Specialty> getSpecialtyByExamId(long examId) {
        return Optional.empty();
    }

    @Override
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("specialty.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Specialty> getAllPaginated(int start, int count) {
        try {
            return queryManager.select(
                    queryManager.getQuery("specialty.findAllPaginated"),
                    (rs) -> Specialty.builder()
                            .id(rs.getLong("id"))
                            .specialtyName(rs.getString("specialty_name"))
                            .governmentOrder(rs.getInt("government_order"))
                            .sendInvitations(rs.getBoolean("send_invitation"))
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
    public List<Specialty> getAll() {
        try {
            return queryManager.select(
                    queryManager.getQuery("specialty.findAll"),
                    (rs) -> Specialty.builder()
                            .id(rs.getLong("id"))
                            .specialtyName(rs.getString("specialty_name"))
                            .governmentOrder(rs.getInt("government_order"))
                            .sendInvitations(rs.getBoolean("send_invitation"))
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Specialty> get(long id) {
        try {
            return queryManager.select(
                    queryManager.getQuery("specialty.findById"),
                    (rs) -> Specialty.builder()
                            .id(rs.getLong("id"))
                            .specialtyName(rs.getString("specialty_name"))
                            .governmentOrder(rs.getInt("government_order"))
                            .sendInvitations(rs.getBoolean("send_invitation"))
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
                    .getQuery("specialty.delete"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean delete(Specialty entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<Specialty> save(Specialty entity) {
        try {
            entity.setId(
                    queryManager.insertAndGetId(
                            queryManager.getQuery("specialty.create"),
                            entity.getSpecialtyName(),
                            entity.getGovernmentOrder(),
                            entity.isSendInvitations()
                    ));
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Specialty> update(Specialty entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("specialty.update"),
                    entity.getSpecialtyName(),
                    entity.getGovernmentOrder(),
                    entity.isSendInvitations(),
                    entity.getId()
            );
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
