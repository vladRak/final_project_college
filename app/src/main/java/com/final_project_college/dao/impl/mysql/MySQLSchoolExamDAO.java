package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.SchoolExamDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.Applicant;
import com.final_project_college.dto.EIEvaluation;
import com.final_project_college.dto.ExamSubject;
import com.final_project_college.dto.SchoolExam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLSchoolExamDAO implements SchoolExamDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLSchoolExamDAO.class);

    public MySQLSchoolExamDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public ExamSubject getExamSubjectBySchoolExamId(long schoolExamId) {
        return null;
    }

    @Override
    public EIEvaluation getEIEvaluationBySchoolExamId(long schoolExamId) {
        return null;
    }

    @Override
    public Applicant getApplicantBySchoolExamId(long schoolExamId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<SchoolExam> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<SchoolExam> findAll() {
        return null;
    }

    @Override
    public SchoolExam getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public SchoolExam create(SchoolExam entity) throws SQLException {
        return null;
    }

    @Override
    public SchoolExam update(SchoolExam entity) {
        return null;
    }

    private void setSchoolExamFieldsToStatement(PreparedStatement ps,
                                                SchoolExam schoolExam) throws SQLException {
        ps.setShort(1, schoolExam.getRating());
        ps.setLong(2, schoolExam.getExamSubjectId());
        ps.setLong(3, schoolExam.getEIEvaluationId());
    }

    private SchoolExam processSchoolExamRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("school_exam.id");
        short rating = rs.getShort("school_exam.rating");
        long examSubjectId = rs.getLong("school_exam.examSubjectId");
        long eIEvaluationId = rs.getLong("school_exam.eIEvaluationId");

        return SchoolExam.builder()
                .id(id)
                .rating(rating)
                .examSubjectId(examSubjectId)
                .eIEvaluationId(eIEvaluationId)
                .build();
    }
}
