package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.CollegeDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLCollegeDAO implements CollegeDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLCollegeDAO.class);

    public MySQLCollegeDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }


    @Override
    public College addSpecialtyToCollege(long specialtyId, long collegeId) {
        return null;
    }

    @Override
    public College removeSpecialtyFromCollege(long specialtyId, long collegeId) {
        return null;
    }

    @Override
    public List<College> getCollegesByName(String collegeName) {
        return null;
    }

    @Override
    public List<Application> getApplicationsByCollegeId(long collegeId) {
        return null;
    }

    @Override
    public List<Specialty> getSpecialtiesByCollegeId(long collegeId) {
        return null;
    }

    @Override
    public List<Branch> getBranchesByCollegeId(long collegeId) {
        return null;
    }

    @Override
    public List<Applicant> getApplicantsByCollegeId(long collegeId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<College> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<College> findAll() {
        return null;
    }

    @Override
    public College getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public College create(College entity) throws SQLException {
        return null;
    }

    @Override
    public College update(College entity) {
        return null;
    }

    private void setCollegeFieldsToStatement(PreparedStatement ps,
                                             College college) throws SQLException {
        ps.setString(1, college.getName());
        ps.setString(2, college.getDescription());
        ps.setLong(3, college.getCityId());
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
