package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.CertificateDAO;
import com.final_project_college.dto.Certificate;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySQLCertificateDAO extends MySQLAbstractDAO implements CertificateDAO {

    private static final Logger logger = LoggerFactory.getLogger(MySQLCertificateDAO.class);

    public MySQLCertificateDAO(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("certificate.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Certificate> findAllPaginated(int start, int count) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("certificate.findAllPaginated"),
                    (rs) -> Certificate.builder()
                            .id(rs.getLong("id"))
                            .series(rs.getString("series"))
                            .serialNumber(rs.getInt("serial_number"))
                            .rating(rs.getBigDecimal("rating"))
                            .scan(rs.getBytes("scan"))
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
    public List<Certificate> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("certificate.findAll"),
                    (rs) -> Certificate.builder()
                            .id(rs.getLong("id"))
                            .series(rs.getString("series"))
                            .serialNumber(rs.getInt("serial_number"))
                            .rating(rs.getBigDecimal("rating"))
                            .scan(rs.getBytes("scan"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<Certificate> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("certificate.findById"),
                    (rs) -> Certificate.builder()
                            .id(rs.getLong("id"))
                            .series(rs.getString("series"))
                            .serialNumber(rs.getInt("serial_number"))
                            .rating(rs.getBigDecimal("rating"))
                            .scan(rs.getBytes("scan"))
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
                    .getQuery("certificate.deleteById"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Certificate create(Certificate entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("certificate.create"),
                    entity.getSeries(),
                    entity.getSerialNumber(),
                    entity.getRating(),
                    entity.getScan()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Certificate update(Certificate entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("certificate.update"),
                    entity.getSeries(),
                    entity.getSerialNumber(),
                    entity.getRating(),
                    entity.getScan(),
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
