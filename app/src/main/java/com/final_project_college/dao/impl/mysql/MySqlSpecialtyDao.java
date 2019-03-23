package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.SpecialtyDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Specialty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlSpecialtyDao extends MySqlAbstractDao implements SpecialtyDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlSpecialtyDao.class);

    public MySqlSpecialtyDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<Specialty> getSpecialtyByExamId(long examId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Specialty> getSpecialtiesByCollegeId(long collegeId) throws SQLException {
        return null;
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("specialty.count"));
    }

    @Override
    public List<Specialty> getAllPaginated(int start, int count) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("specialty.findAllPaginated"),
                (rs) -> Specialty.builder()
                        .id(rs.getLong("id"))
                        .specialtyName(rs.getString("specialty_name"))
                        .build(),
                start,
                count
        );
    }

    @Override
    public List<Specialty> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("specialty.findAll"),
                (rs) -> Specialty.builder()
                        .id(rs.getLong("id"))
                        .specialtyName(rs.getString("specialty_name"))
                        .build());
    }

    @Override
    public Optional<Specialty> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("specialty.findById"),
                (rs) -> Specialty.builder()
                        .id(rs.getLong("id"))
                        .specialtyName(rs.getString("specialty_name"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("specialty.delete"));

    }

    @Override
    public boolean delete(Specialty entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public Specialty save(Specialty entity) throws SQLException {
        return Specialty.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("specialty.create")))
                .specialtyName(entity.getSpecialtyName())
                .build();
    }

    @Override
    public Specialty update(Specialty entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("specialty.update"),
                entity.getSpecialtyName(),
                entity.getId()
        );

        return entity;
    }
}
