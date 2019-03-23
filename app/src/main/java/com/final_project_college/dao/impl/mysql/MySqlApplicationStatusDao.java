package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.ApplicationStatusDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.ApplicationStatus;
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
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("application_status.count"));
    }

    @Override
    public List<ApplicationStatus> getAllPaginated(int start, int count) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("application_status.findAllPaginated"),
                (rs) -> ApplicationStatus.builder()
                        .id(rs.getLong("id"))
                        .statusName("status_name")
                        .build(),
                start,
                count
        );
    }

    @Override
    public List<ApplicationStatus> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("application_status.findAll"),
                (rs) -> ApplicationStatus.builder()
                        .id(rs.getLong("id"))
                        .statusName("status_name")
                        .build());
    }

    @Override
    public Optional<ApplicationStatus> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("application_status.findById"),
                (rs) -> ApplicationStatus.builder()
                        .id(rs.getLong("id"))
                        .statusName("status_name")
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("application_status.deleteById"));
    }

    @Override
    public boolean delete(ApplicationStatus entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public ApplicationStatus save(ApplicationStatus entity) throws SQLException {
        return ApplicationStatus.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("application_status.create")))
                .statusName(entity.getStatusName())
                .build();
    }

    @Override
    public ApplicationStatus update(ApplicationStatus entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("application_status.update"),
                entity.getStatusName(),
                entity.getId()
        );

        return entity;
    }
}
