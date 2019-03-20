package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.ApplicationStatusDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.Application;
import com.final_project_college.dto.ApplicationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLApplicationStatusDAO implements ApplicationStatusDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLApplicationStatusDAO.class);

    public MySQLApplicationStatusDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public List<Application> getApplicationsByStatusId(long statusId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<ApplicationStatus> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<ApplicationStatus> findAll() {
        return null;
    }

    @Override
    public ApplicationStatus getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public ApplicationStatus create(ApplicationStatus entity) throws SQLException {
        return null;
    }

    @Override
    public ApplicationStatus update(ApplicationStatus entity) {
        return null;
    }

    private void setApplicationStatusFieldsToStatement(PreparedStatement ps,
                                                       ApplicationStatus applicationStatus
    ) throws SQLException {
        ps.setString(1, applicationStatus.getStatusName());
    }

    private ApplicationStatus processApplicationStatusRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("application_status.id");
        String statusName = rs.getString("application_status.status_name");

        return ApplicationStatus.builder()
                .id(id)
                .statusName(statusName)
                .build();
    }
}
