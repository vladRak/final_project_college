package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.CityDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.City;
import com.final_project_college.dto.College;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySQLCityDAO extends MySQLAbstractDAO implements CityDAO {

    private static final Logger logger = LoggerFactory.getLogger(MySQLCityDAO.class);

    public MySQLCityDAO(ConnectionWrapper connection) {
       super(connection);
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("city.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<City> findAllPaginated(int start, int count) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("city.findAllPaginated"),
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
    public List<City> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("city.findAll"),
                    (rs) -> City.builder()
                            .id(rs.getLong("id"))
                            .cityName(rs.getString("city_name"))
                            .regionId(rs.getLong("region_id"))
                            .cityCoefficient(rs.getBigDecimal("city_coefficient"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<City> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("city.findById"),
                    (rs) -> City.builder()
                            .id(rs.getLong("id"))
                            .cityName(rs.getString("city_name"))
                            .regionId(rs.getLong("region_id"))
                            .cityCoefficient(rs.getBigDecimal("city_coefficient"))
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
                    .getQuery("city.deleteById"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public City create(City entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("city.create"),
                    entity.getCityName(),
                    entity.getRegionId(),
                    entity.getCoefficient()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public City update(City entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("city.update"),
                    entity.getCityName(),
                    entity.getRegionId(),
                    entity.getCoefficient(),
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
