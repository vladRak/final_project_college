package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.SpecialtyDao;
import com.final_project_college.domain.dto.Specialty;
import com.final_project_college.exception.DataAccessException;
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
    public Optional<Specialty> getSpecialtyByExamId(long examId) {
        return Optional.empty();
    }

    @Override
    public List<Specialty> getSpecialtiesByCollegeId(long collegeId) {
        return null;
    }

    @Override
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("specialty.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Specialty> getAllPaginated(int start, int count) {
        try {
            return queryManager.select(
                    queryManager.getQuery("specialty.findAllPaginated"),
                    (rs) -> Specialty.builder()
                            .id(rs.getLong("id"))
                            .specialtyName(rs.getString("specialty_name"))
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
    public List<Specialty> getAll() {
        try {
            return queryManager.select(
                    queryManager.getQuery("specialty.findAll"),
                    (rs) -> Specialty.builder()
                            .id(rs.getLong("id"))
                            .specialtyName(rs.getString("specialty_name"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<Specialty> get(long id) {
        try {
            return queryManager.select(
                    queryManager.getQuery("specialty.findById"),
                    (rs) -> Specialty.builder()
                            .id(rs.getLong("id"))
                            .specialtyName(rs.getString("specialty_name"))
                            .build(),
                    id).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean delete(long id) {
        try {

            return deleteById(id, queryManager
                    .getQuery("specialty.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Specialty entity) {
        return delete(entity.getId());
    }

    @Override
    public Specialty save(Specialty entity) {
        try {
            return Specialty.builder()
                    .id(queryManager.insertAndGetId(
                            queryManager.getQuery("specialty.create")))
                    .specialtyName(entity.getSpecialtyName())
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Specialty update(Specialty entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("specialty.update"),
                    entity.getSpecialtyName(),
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
