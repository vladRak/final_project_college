package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.ApplicationStatusDao;
import com.final_project_college.domain.dto.ApplicationStatus;
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
    public int numberOfRows() {
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
    public List<ApplicationStatus> getAllPaginated(int start, int count) {
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
    public List<ApplicationStatus> getAll() {
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
    public Optional<ApplicationStatus> get(long id) {
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
    public boolean delete(long id) {
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
    public boolean delete(ApplicationStatus entity) {
        return delete(entity.getId());
    }

    @Override
    public ApplicationStatus save(ApplicationStatus entity) {
        try {
            return ApplicationStatus.builder()
                    .id(queryManager.insertAndGetId(
                            queryManager.getQuery("application_status.create")))
                    .statusName(entity.getStatusName())
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public ApplicationStatus update(ApplicationStatus entity) {
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
