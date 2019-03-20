package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.CityDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.City;
import com.final_project_college.dto.College;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLCityDAO implements CityDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLCityDAO.class);

    public MySQLCityDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public List<College> getCollegesByCityId(long cityId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<City> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public City getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public City create(City entity) throws SQLException {
        return null;
    }

    @Override
    public City update(City entity) {
        return null;
    }

    private void setCityFieldsToStatement(PreparedStatement ps,
                                          City city) throws SQLException {
        ps.setString(1, city.getCityName());
        ps.setLong(2, city.getRegionId());

    }

    private City processCityRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("city.id");
        String cityName = rs.getString("city.city_name");
        long regionId = rs.getLong("certificate.region_id");

        return City.builder()
                .id(id)
                .cityName(cityName)
                .regionId(regionId)
                .build();
    }
}
