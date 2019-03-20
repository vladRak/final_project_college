package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.EIEvaluationDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.EIEvaluation;
import com.final_project_college.dto.SchoolExam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLEIEvaluationDAO implements EIEvaluationDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLEIEvaluationDAO.class);

    public MySQLEIEvaluationDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public List<SchoolExam> getEvaluationExams(long eIEvaluationId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<EIEvaluation> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<EIEvaluation> findAll() {
        return null;
    }

    @Override
    public EIEvaluation getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public EIEvaluation create(EIEvaluation entity) throws SQLException {
        return null;
    }

    @Override
    public EIEvaluation update(EIEvaluation entity) {
        return null;
    }

    private void setEIEvaluationFieldsToStatement(PreparedStatement ps,
                                                  EIEvaluation eiEvaluation) throws SQLException {
        ps.setInt(1, eiEvaluation.getYear());
        ps.setInt(2, eiEvaluation.getSerialNumber());
        ps.setInt(3, eiEvaluation.getPin());
        ps.setBytes(4, eiEvaluation.getScan());
    }

    private EIEvaluation processEIEvaluationRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("e_i_evaluation.id");
        int year = rs.getInt("e_i_evaluation.year");
        int serialNumber = rs.getInt("e_i_evaluation.serial_number");
        int pin = rs.getInt("e_i_evaluation.pin");
        byte[] scan = rs.getBytes("e_i_evaluation.scan");


        return EIEvaluation.builder()
                .id(id)
                .year(year)
                .serialNumber(serialNumber)
                .pin(pin)
                .scan(scan)
                .build();
    }
}
