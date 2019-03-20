package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.SpecialtyDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLSpecialtyDAO implements SpecialtyDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLSpecialtyDAO.class);

    public MySQLSpecialtyDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public Specialty addCollegeToSpecialty(long collegeId, long specialtyId) {
        return null;
    }

    @Override
    public Specialty removeCollegeFromSpecialty(long collegeId, long specialtyId) {
        return null;
    }

    @Override
    public Branch getBranchBySpecialtyId(long specialtyId) {
        return null;
    }

    @Override
    public List<College> getCollegesBySpecialtyId(long specialtyId) {
        return null;
    }

    @Override
    public List<Application> getApplicationsBySpecialtyId(long specialtyId) {
        return null;
    }

    @Override
    public List<EntranceExam> getEntranceExamsBySpecialtyId(long specialtyId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<Specialty> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Specialty> findAll() {
        return null;
    }

    @Override
    public Specialty getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Specialty create(Specialty entity) throws SQLException {
        return null;
    }

    @Override
    public Specialty update(Specialty entity) {
        return null;
    }

    private void setSpecialtyFieldsToStatement(PreparedStatement ps,
                                               Specialty specialty) throws SQLException {
        ps.setShort(1, specialty.getSpecialtyCode());
        ps.setString(2, specialty.getSpecialtyName());
        ps.setLong(3, specialty.getBranchId());
    }

    private Specialty processSpecialtyRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("specialty.id");
        short specialtyCode = rs.getShort("specialty.specialty_code");
        String specialtyName = rs.getString("specialty.specialty_name");
        long branchId = rs.getLong("specialty.branch_id");

        return Specialty.builder()
                .id(id)
                .specialtyCode(specialtyCode)
                .specialtyName(specialtyName)
                .branchId(branchId)
                .build();
    }
}
