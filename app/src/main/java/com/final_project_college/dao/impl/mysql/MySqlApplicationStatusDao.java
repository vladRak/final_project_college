package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.ApplicationStatusDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.ApplicationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlApplicationStatusDao extends MySqlAbstractDao implements ApplicationStatusDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlApplicationStatusDao.class);

    public MySqlApplicationStatusDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<ApplicationStatus> getByName(String statusName) {
        try {
            return queryManager.select(
                    queryManager.getQuery("application_status.findByName"),
                    (rs) -> ApplicationStatus.builder()
                            .id(rs.getLong("id"))
                            .statusName("status_name")
                            .build(),
                    statusName).stream().findFirst();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("application_status.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
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
            logger.error(e.getMessage());
            return Collections.emptyList();
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
            logger.error(e.getMessage());
            return Collections.emptyList();
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
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            return deleteById(id, queryManager
                    .getQuery("application_status.deleteById"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(ApplicationStatus entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<ApplicationStatus> save(ApplicationStatus entity) {
        try {

            entity.setId(
                    queryManager.insertAndGetId(
                            queryManager.getQuery("application_status.create"),
                            entity.getStatusName()
                    ));

            return Optional.of(entity);

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ApplicationStatus> update(ApplicationStatus entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("application_status.update"),
                    entity.getStatusName(),
                    entity.getId()
            );
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
