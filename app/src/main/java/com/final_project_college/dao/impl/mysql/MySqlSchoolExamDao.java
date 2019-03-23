package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.SchoolExamDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.SchoolExam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlSchoolExamDao extends MySqlAbstractDao implements SchoolExamDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlSchoolExamDao.class);

    public MySqlSchoolExamDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<SchoolExam> getSchoolExamsByApplicantId(long applicantId) throws SQLException {
        return null;
    }

    @Override
    public List<SchoolExam> getSchoolExamsByExamSubjectId(long examSubjectId) throws SQLException {
        return null;
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("school_exam.count"));
    }

    @Override
    public List<SchoolExam> getAllPaginated(int start, int count) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("school_exam.findAllPaginated"),
                (rs) -> SchoolExam.builder()
                        .id(rs.getLong("id"))
                        .rating(rs.getShort("rating"))
                        .examSubjectId(rs.getLong("exam_subject_id"))
                        .applicantId(rs.getLong("applicant_id"))
                        .build(),
                start,
                count
        );
    }

    @Override
    public List<SchoolExam> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("school_exam.findAll"),
                (rs) -> SchoolExam.builder()
                        .id(rs.getLong("id"))
                        .rating(rs.getShort("rating"))
                        .examSubjectId(rs.getLong("exam_subject_id"))
                        .applicantId(rs.getLong("applicant_id"))
                        .build());
    }

    @Override
    public Optional<SchoolExam> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("school_exam.findById"),
                (rs) -> SchoolExam.builder()
                        .id(rs.getLong("id"))
                        .rating(rs.getShort("rating"))
                        .examSubjectId(rs.getLong("exam_subject_id"))
                        .applicantId(rs.getLong("applicant_id"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("school_exam.delete"));
    }

    @Override
    public boolean delete(SchoolExam entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public SchoolExam save(SchoolExam entity) throws SQLException {
        return SchoolExam.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("school_exam.create")))
                .rating(entity.getRating())
                .examSubjectId(entity.getExamSubjectId())
                .applicantId(entity.getApplicantId())
                .build();
    }

    @Override
    public SchoolExam update(SchoolExam entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("school_exam.update"),
                entity.getRating(),
                entity.getExamSubjectId(),
                entity.getApplicantId(),
                entity.getId()
        );

        return entity;
    }
}
