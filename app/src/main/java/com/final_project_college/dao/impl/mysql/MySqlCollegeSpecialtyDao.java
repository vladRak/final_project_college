package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.CollegeSpecialtyDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.CollegeSpecialty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlCollegeSpecialtyDao extends MySqlAbstractDao implements CollegeSpecialtyDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlCollegeSpecialtyDao.class);

    public MySqlCollegeSpecialtyDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<CollegeSpecialty> getCollegeSpecialtiesByCollegeId(long collegeId) throws SQLException {
        return null;
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("college_specialty.count"));
    }

    @Override
    public List<CollegeSpecialty> getAllPaginated(int start, int count) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("college_specialty.findAllPaginated"),
                (rs) -> CollegeSpecialty.builder()
                        .id(rs.getLong("id"))
                        .collegeId(rs.getLong("college_id"))
                        .specialtyId(rs.getLong("specialty_id"))
                        .governmentOrder(rs.getInt("government_order"))
                        .contractOrder(rs.getInt("contract_order"))
                        .build(),
                start,
                count
        );
    }

    @Override
    public List<CollegeSpecialty> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("college_specialty.findAll"),
                (rs) -> CollegeSpecialty.builder()
                        .id(rs.getLong("id"))
                        .collegeId(rs.getLong("college_id"))
                        .specialtyId(rs.getLong("specialty_id"))
                        .governmentOrder(rs.getInt("government_order"))
                        .contractOrder(rs.getInt("contract_order"))
                        .build());
    }

    @Override
    public Optional<CollegeSpecialty> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("college_specialty.findById"),
                (rs) -> CollegeSpecialty.builder()
                        .id(rs.getLong("id"))
                        .collegeId(rs.getLong("college_id"))
                        .specialtyId(rs.getLong("specialty_id"))
                        .governmentOrder(rs.getInt("government_order"))
                        .contractOrder(rs.getInt("contract_order"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("college_specialty.delete"));
    }

    @Override
    public boolean delete(CollegeSpecialty entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public CollegeSpecialty save(CollegeSpecialty entity) throws SQLException {
        return CollegeSpecialty.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("college_specialty.create")))
                .collegeId(entity.getCollegeId())
                .specialtyId(entity.getSpecialtyId())
                .governmentOrder(entity.getGovernmentOrder())
                .contractOrder(entity.getContractOrder())
                .build();
    }

    @Override
    public CollegeSpecialty update(CollegeSpecialty entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("college_specialty.update"),
                entity.getCollegeId(),
                entity.getSpecialtyId(),
                entity.getGovernmentOrder(),
                entity.getContractOrder(),
                entity.getId()
        );

        return entity;
    }
}
