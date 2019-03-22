package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.ApplicationStatusDao;
import com.final_project_college.persistence.dto.ApplicationStatus;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlApplicationStatusDao extends MySqlAbstractDao implements ApplicationStatusDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlApplicationStatusDao.class);

    public MySqlApplicationStatusDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("application_status.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<ApplicationStatus> findAllPaginated(int start, int count) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("application_status.findAllPaginated"),
                    (rs) -> ApplicationStatus.builder()
                            .id(rs.getLong("id"))
                            .statusName("status_name")
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
    public List<ApplicationStatus> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("application_status.findAll"),
                    (rs) -> ApplicationStatus.builder()
                            .id(rs.getLong("id"))
                            .statusName("status_name")
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<ApplicationStatus> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("application_status.findById"),
                    (rs) -> ApplicationStatus.builder()
                            .id(rs.getLong("id"))
                            .statusName("status_name")
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
                    .getQuery("application_status.deleteById"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public ApplicationStatus create(ApplicationStatus entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("application_status.create"),
                    entity.getStatusName()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public ApplicationStatus update(ApplicationStatus entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("application_status.update"),
                    entity.getStatusName(),
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
