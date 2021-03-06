package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.ExamSubjectDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.ExamSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
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
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("exam_subject.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<ExamSubject> getAllPaginated(int start, int count) {
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
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<ExamSubject> getAll() {
        try {
            return queryManager.select(
                    queryManager.getQuery("exam_subject.findAll"),
                    (rs) -> ExamSubject.builder()
                            .id(rs.getLong("id"))
                            .subjectName(rs.getString("subject_name"))
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<ExamSubject> get(long id) {
        try {
            return queryManager.select(
                    queryManager.getQuery("exam_subject.findById"),
                    (rs) -> ExamSubject.builder()
                            .id(rs.getLong("id"))
                            .subjectName(rs.getString("subject_name"))
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
                    .getQuery("exam_subject.delete"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(ExamSubject entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<ExamSubject> save(ExamSubject entity) {
        try {
            entity.setId(
                    queryManager.insertAndGetId(
                            queryManager.getQuery("exam_subject.create"),
                            entity.getSubjectName()
                    ));
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ExamSubject> update(ExamSubject entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("exam_subject.update"),
                    entity.getSubjectName(),
                    entity.getId()
            );
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
