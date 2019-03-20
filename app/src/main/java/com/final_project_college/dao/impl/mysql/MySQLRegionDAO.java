package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.RegionDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.City;
import com.final_project_college.dto.College;
import com.final_project_college.dto.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLRegionDAO implements RegionDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLRegionDAO.class);

    public MySQLRegionDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public List<City> getCitiesByRegionId(long regionId) {
        return null;
    }

    @Override
    public List<College> getCollegesByRegionId(long regionId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<Region> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Region> findAll() {
        return null;
    }

    @Override
    public Region getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Region create(Region entity) throws SQLException {
        return null;
    }

    @Override
    public Region update(Region entity) {
        return null;
    }

    private void setRegionFieldsToStatement(PreparedStatement ps,
                                            Region region) throws SQLException {
        ps.setBigDecimal(1, region.getCoefficient());
        ps.setString(2, region.getRegionName());
    }

    private Region processRegionRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("region.id");
        BigDecimal regionCoefficient = rs.getBigDecimal("region.region_coefficient");
        String regionName = rs.getString("region.region_name");

        return Region.builder()
                .id(id)
                .regionCoefficient(regionCoefficient)
                .regionName(regionName)
                .build();
    }
}
