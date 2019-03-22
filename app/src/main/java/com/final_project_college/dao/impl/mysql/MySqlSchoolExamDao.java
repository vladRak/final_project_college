package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.SchoolExamDao;
import com.final_project_college.dto.SchoolExam;
import com.final_project_college.exception.DataAccessException;
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
    public List<SchoolExam> getSchoolExamsByApplicantId(long applicantId) {
        return null;
    }

    @Override
    public List<SchoolExam> getSchoolExamsByExamSubjectId(long examSubjectId) {
        return null;
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("school_exam.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<SchoolExam> findAllPaginated(int start, int count) throws DataAccessException {
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<SchoolExam> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("school_exam.findAll"),
                    (rs) -> SchoolExam.builder()
                            .id(rs.getLong("id"))
                            .rating(rs.getShort("rating"))
                            .examSubjectId(rs.getLong("exam_subject_id"))
                            .applicantId(rs.getLong("applicant_id"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<SchoolExam> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("school_exam.findById"),
                    (rs) -> SchoolExam.builder()
                            .id(rs.getLong("id"))
                            .rating(rs.getShort("rating"))
                            .examSubjectId(rs.getLong("exam_subject_id"))
                            .applicantId(rs.getLong("applicant_id"))
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
                    .getQuery("school_exam.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public SchoolExam create(SchoolExam entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("school_exam.create"),
                    entity.getRating(),
                    entity.getExamSubjectId(),
                    entity.getApplicantId()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public SchoolExam update(SchoolExam entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("school_exam.update"),
                    entity.getRating(),
                    entity.getExamSubjectId(),
                    entity.getApplicantId(),
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
