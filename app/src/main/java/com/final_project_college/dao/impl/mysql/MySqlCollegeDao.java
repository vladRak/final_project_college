package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.CollegeDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.College;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.exception.ExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlCollegeDao extends MySqlAbstractDao implements CollegeDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlCollegeDao.class);

    public MySqlCollegeDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<College> getCollegesByName(String collegeName) throws SQLException {
        return null;
    }

    @Override
    public List<College> getCollegesBySpecialtyId(long specialtyId) throws SQLException {
        return null;
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("college.count"));
    }

    @Override
    public List<College> getAllPaginated(int start, int count) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("college.findAllPaginated"),
                (rs) -> College.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("college_name"))
                        .description(rs.getString("college_description"))
                        .build(),
                start,
                count
        );
    }

    @Override
    public List<College> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("college.findAll"),
                (rs) -> College.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("college_name"))
                        .description(rs.getString("college_description"))
                        .build());
    }

    @Override
    public Optional<College> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("college.findById"),
                (rs) -> College.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("college_name"))
                        .description(rs.getString("college_description"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("college.delete"));
    }

    @Override
    public boolean delete(College entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public College save(College entity) throws SQLException {
        return College.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("college.create")))
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public College update(College entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("college.update"),
                entity.getName(),
                entity.getDescription(),
                entity.getId()
        );

        return entity;
    }
}
