package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.ExamSubjectDao;
import com.final_project_college.dto.ExamSubject;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlExamSubjectDao extends MySqlAbstractDao implements ExamSubjectDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlRoleDao.class);

    public MySqlExamSubjectDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<ExamSubject> getExamSubjectBySchoolExamId(long schoolExamId) {
        return Optional.empty();
    }

    @Override
    public Optional<ExamSubject> getExamSubjectByEntranceExamId(long entranceExamId) {
        return Optional.empty();
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("exam_subject.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<ExamSubject> findAllPaginated(int start, int count) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("exam_subject.findAllPaginated"),
                    (rs) -> ExamSubject.builder()
                            .id(rs.getLong("id"))
                            .subjectName(rs.getString("subject_name"))
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
    public List<ExamSubject> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("exam_subject.findAll"),
                    (rs) -> ExamSubject.builder()
                            .id(rs.getLong("id"))
                            .subjectName(rs.getString("subject_name"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<ExamSubject> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("exam_subject.findById"),
                    (rs) -> ExamSubject.builder()
                            .id(rs.getLong("id"))
                            .subjectName(rs.getString("subject_name"))
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
                    .getQuery("exam_subject.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public ExamSubject create(ExamSubject entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("exam_subject.create"),
                    entity.getSubjectName()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public ExamSubject update(ExamSubject entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("exam_subject.update"),
                    entity.getSubjectName(),
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
