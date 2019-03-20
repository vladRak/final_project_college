package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.EntranceExamDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.EntranceExam;
import com.final_project_college.dto.Specialty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLEntranceExamDAO implements EntranceExamDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLEntranceExamDAO.class);

    public MySQLEntranceExamDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public Specialty getSpecialtyByExamId(long examId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<EntranceExam> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<EntranceExam> findAll() {
        return null;
    }

    @Override
    public EntranceExam getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public EntranceExam create(EntranceExam entity) throws SQLException {
        return null;
    }

    @Override
    public EntranceExam update(EntranceExam entity) {
        return null;
    }

    private void setEntranceExamFieldsToStatement(PreparedStatement ps,
                                                  EntranceExam entranceExam) throws SQLException {
        ps.setShort(1, entranceExam.getMinRating());
        ps.setLong(2, entranceExam.getExamSubjectId());
        ps.setLong(3, entranceExam.getSpecialtyId());
    }

    private EntranceExam processEntranceExamRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("entrance_exam.id");
        short minRating = rs.getShort("entrance_exam.min_rating");
        long examSubjectId = rs.getLong("entrance_exam.exam_subject_id");
        long specialtyId = rs.getLong("entrance_exam.specialty_id");

        return EntranceExam.builder()
                .id(id)
                .minRating(minRating)
                .examSubjectId(examSubjectId)
                .specialtyId(specialtyId)
                .build();
    }
}
