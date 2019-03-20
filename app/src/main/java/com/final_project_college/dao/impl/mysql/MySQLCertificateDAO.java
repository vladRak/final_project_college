package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.CertificateDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.Applicant;
import com.final_project_college.dto.Certificate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLCertificateDAO implements CertificateDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLCertificateDAO.class);

    public MySQLCertificateDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public List<Applicant> getApplicantsByRating() {
        return null;
    }

    @Override
    public List<Applicant> getApplicantsWithConcreteRating(BigDecimal rating) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<Certificate> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Certificate> findAll() {
        return null;
    }

    @Override
    public Certificate getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Certificate create(Certificate entity) throws SQLException {
        return null;
    }

    @Override
    public Certificate update(Certificate entity) {
        return null;
    }

    private void setCertificateFieldsToStatement(PreparedStatement ps,
                                                 Certificate certificate) throws SQLException {
        ps.setString(1, certificate.getSeries());
        ps.setInt(2, certificate.getSerialNumber());
        ps.setBigDecimal(3, certificate.getRating());
        ps.setBytes(4, certificate.getScan());
    }

    private Certificate processCertificateRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("certificate.id");
        String series = rs.getString("certificate.series");
        int serialNumber = rs.getInt("certificate.serial_number");
        BigDecimal rating = rs.getBigDecimal("certificate.rating");
        byte[] scan = rs.getBytes("certificate.scan");

        return Certificate.builder()
                .id(id)
                .series(series)
                .serialNumber(serialNumber)
                .rating(rating)
                .scan(scan)
                .build();
    }
}
