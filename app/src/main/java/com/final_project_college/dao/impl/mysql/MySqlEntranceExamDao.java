package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.EntranceExamDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.EntranceExam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlEntranceExamDao extends MySqlAbstractDao implements EntranceExamDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlEntranceExamDao.class);

    public MySqlEntranceExamDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<EntranceExam> getEntranceExamsBySpecialtyId(long specialtyId) {
        return null;
    }

    @Override
    public List<EntranceExam> getEntranceExamsByExamSubjectId(long examSubjectId) {
        return null;
    }

    @Override
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("entrance_exam.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<EntranceExam> getAllPaginated(int start, int count) {
        try {
            return queryManager.select(
                    queryManager.getQuery("entrance_exam.findAllPaginated"),
                    (rs) -> EntranceExam.builder()
                            .id(rs.getLong("id"))
                            .minRating(rs.getShort("min_rating"))
                            .examSubjectId(rs.getLong("exam_subject_id"))
                            .specialtyId(rs.getLong("specialty_id"))
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
    public List<EntranceExam> getAll() {
        try {
            return queryManager.select(
                    queryManager.getQuery("entrance_exam.findAll"),
                    (rs) -> EntranceExam.builder()
                            .id(rs.getLong("id"))
                            .minRating(rs.getShort("min_rating"))
                            .examSubjectId(rs.getLong("exam_subject_id"))
                            .specialtyId(rs.getLong("specialty_id"))
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<EntranceExam> get(long id) {
        try {
            return queryManager.select(
                    queryManager.getQuery("entrance_exam.findById"),
                    (rs) -> EntranceExam.builder()
                            .id(rs.getLong("id"))
                            .minRating(rs.getShort("min_rating"))
                            .examSubjectId(rs.getLong("exam_subject_id"))
                            .specialtyId(rs.getLong("specialty_id"))
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
                    .getQuery("entrance_exam.delete"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(EntranceExam entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<EntranceExam> save(EntranceExam entity) {
        try {

            entity.setId(
                    queryManager.insertAndGetId(
                            queryManager.getQuery("entrance_exam.create"),
                            entity.getMinRating(),
                            entity.getExamSubjectId(),
                            entity.getSpecialtyId()
                    ));
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<EntranceExam> update(EntranceExam entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("entrance_exam.update"),
                    entity.getMinRating(),
                    entity.getExamSubjectId(),
                    entity.getSpecialtyId(),
                    entity.getId()
            );
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
