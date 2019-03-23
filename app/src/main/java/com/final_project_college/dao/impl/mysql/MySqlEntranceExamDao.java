package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.EntranceExamDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.EntranceExam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlEntranceExamDao extends MySqlAbstractDao implements EntranceExamDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlEntranceExamDao.class);

    public MySqlEntranceExamDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<EntranceExam> getEntranceExamsBySpecialtyId(long specialtyId) throws SQLException {
        return null;
    }

    @Override
    public List<EntranceExam> getEntranceExamsByExamSubjectId(long examSubjectId) throws SQLException {
        return null;
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("entrance_exam.count"));
    }

    @Override
    public List<EntranceExam> getAllPaginated(int start, int count) throws SQLException {
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
    }

    @Override
    public List<EntranceExam> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("entrance_exam.findAll"),
                (rs) -> EntranceExam.builder()
                        .id(rs.getLong("id"))
                        .minRating(rs.getShort("min_rating"))
                        .examSubjectId(rs.getLong("exam_subject_id"))
                        .specialtyId(rs.getLong("specialty_id"))
                        .build());
    }

    @Override
    public Optional<EntranceExam> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("entrance_exam.findById"),
                (rs) -> EntranceExam.builder()
                        .id(rs.getLong("id"))
                        .minRating(rs.getShort("min_rating"))
                        .examSubjectId(rs.getLong("exam_subject_id"))
                        .specialtyId(rs.getLong("specialty_id"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("entrance_exam.delete"));
    }

    @Override
    public boolean delete(EntranceExam entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public EntranceExam save(EntranceExam entity) throws SQLException {
        return EntranceExam.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("entrance_exam.create")))
                .minRating(entity.getMinRating())
                .examSubjectId(entity.getExamSubjectId())
                .specialtyId(entity.getSpecialtyId())
                .build();
    }

    @Override
    public EntranceExam update(EntranceExam entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("entrance_exam.update"),
                entity.getMinRating(),
                entity.getExamSubjectId(),
                entity.getSpecialtyId(),
                entity.getId()
        );

        return entity;
    }
}
