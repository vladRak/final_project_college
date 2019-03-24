package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.ExamSubjectDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.ExamSubject;
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
    public Optional<ExamSubject> getExamSubjectBySchoolExamId(long schoolExamId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<ExamSubject> getExamSubjectByEntranceExamId(long entranceExamId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int numberOfRows() throws SQLException {
            return getNumberOfRows(queryManager
                    .getQuery("exam_subject.count"));
    }

    @Override
    public List<ExamSubject> getAllPaginated(int start, int count) throws SQLException {
            return queryManager.select(
                    queryManager.getQuery("exam_subject.findAllPaginated"),
                    (rs) -> ExamSubject.builder()
                            .id(rs.getLong("id"))
                            .subjectName(rs.getString("subject_name"))
                            .build(),
                    start,
                    count
            );
    }

    @Override
    public List<ExamSubject> getAll() throws SQLException {
            return queryManager.select(
                    queryManager.getQuery("exam_subject.findAll"),
                    (rs) -> ExamSubject.builder()
                            .id(rs.getLong("id"))
                            .subjectName(rs.getString("subject_name"))
                            .build());
    }

    @Override
    public Optional<ExamSubject> get(long id) throws SQLException {
            return queryManager.select(
                    queryManager.getQuery("exam_subject.findById"),
                    (rs) -> ExamSubject.builder()
                            .id(rs.getLong("id"))
                            .subjectName(rs.getString("subject_name"))
                            .build(),
                    id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
            return deleteById(id, queryManager
                    .getQuery("exam_subject.delete"));
    }

    @Override
    public boolean delete(ExamSubject entity) throws SQLException {
            return delete(entity.getId());
    }

    @Override
    public ExamSubject save(ExamSubject entity) throws SQLException {
            return ExamSubject.builder()
                    .id(queryManager.insertAndGetId(
                            queryManager.getQuery("exam_subject.create")))
                    .subjectName(entity.getSubjectName())
                    .build();
    }

    @Override
    public ExamSubject update(ExamSubject entity) throws SQLException {
            queryManager.update(
                    queryManager.getQuery("exam_subject.update"),
                    entity.getSubjectName(),
                    entity.getId()
            );

            return entity;
    }
}
