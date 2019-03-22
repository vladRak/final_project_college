package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.EntranceExamDao;
import com.final_project_college.dto.EntranceExam;
import com.final_project_college.exception.DataAccessException;
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
    public List<EntranceExam> getEntranceExamsBySpecialtyId(long specialtyId) {
        return null;
    }

    @Override
    public List<EntranceExam> getEntranceExamsByExamSubjectId(long examSubjectId) {
        return null;
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("entrance_exam.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<EntranceExam> findAllPaginated(int start, int count) throws DataAccessException {
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
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<EntranceExam> findAll() throws DataAccessException {
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
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<EntranceExam> getEntityById(long id) throws DataAccessException {
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
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws DataAccessException {
        try {

            return deleteById(id, queryManager
                    .getQuery("entrance_exam.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public EntranceExam create(EntranceExam entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("entrance_exam.create"),
                    entity.getMinRating(),
                    entity.getExamSubjectId(),
                    entity.getSpecialtyId()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public EntranceExam update(EntranceExam entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("entrance_exam.update"),
                    entity.getMinRating(),
                    entity.getExamSubjectId(),
                    entity.getSpecialtyId(),
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
