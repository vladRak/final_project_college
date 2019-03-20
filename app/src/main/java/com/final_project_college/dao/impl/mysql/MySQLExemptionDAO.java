package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.ExemptionDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.Applicant;
import com.final_project_college.dto.Exemption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLExemptionDAO implements ExemptionDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLExemptionDAO.class);

    public MySQLExemptionDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public Applicant getApplicantByExemptionId(long exemptionId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<Exemption> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Exemption> findAll() {
        return null;
    }

    @Override
    public Exemption getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Exemption create(Exemption entity) throws SQLException {
        return null;
    }

    @Override
    public Exemption update(Exemption entity) {
        return null;
    }

    private void setExemptionFieldsToStatement(PreparedStatement ps,
                                               Exemption exemption) throws SQLException {
        ps.setBoolean(1, exemption.isValid());
        ps.setBytes(2, exemption.getScan());
    }

    private Exemption processExemptionRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("exemption.id");
        boolean valid = rs.getBoolean("exemption.valid");
        byte[] scan = rs.getBytes("exemption.scan");

        return Exemption.builder()
                .id(id)
                .valid(valid)
                .scan(scan)
                .build();
    }
}
