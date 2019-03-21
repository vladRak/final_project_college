package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.CollegeDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.*;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySQLCollegeDAO extends MySQLAbstractDAO implements CollegeDAO {

    private static final Logger logger = LoggerFactory.getLogger(MySQLCollegeDAO.class);

    public MySQLCollegeDAO(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("college.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<College> findAllPaginated(int start, int count) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("college.findAllPaginated"),
                    (rs) -> City.builder()
                            .id(rs.getLong("id"))
                            .cityName(rs.getString("city_name"))
                            .regionId(rs.getLong("region_id"))
                            .cityCoefficient(rs.getBigDecimal("city_coefficient"))
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
    public List<College> findAll() throws DataAccessException {
        return null;
    }

    @Override
    public Optional<College> getEntityById(long id) throws DataAccessException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(long id) throws DataAccessException {
        return false;
    }

    @Override
    public College create(College entity) throws DataAccessException {
        return null;
    }

    @Override
    public College update(College entity) throws DataAccessException {
        return null;
    }

    private College processCollegeRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("college.id");
        String name = rs.getString("college.college_name");
        String description = rs.getString("college.college_description");
        long cityId = rs.getLong("college.city_id");

        return College.builder()
                .id(id)
                .name(name)
                .description(description)
                .cityId(cityId)
                .build();
    }
}
