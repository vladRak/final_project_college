package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.SpecialtyDao;
import com.final_project_college.dto.Specialty;
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
    public int getNumberOfRows() throws DataAccessException {
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
    public List<Specialty> findAllPaginated(int start, int count) throws DataAccessException {
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
    public List<Specialty> findAll() throws DataAccessException {
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
    public Optional<Specialty> getEntityById(long id) throws DataAccessException {
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
    public boolean deleteById(long id) throws DataAccessException {
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
    public Specialty create(Specialty entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("specialty.create"),
                    entity.getSpecialtyName()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Specialty update(Specialty entity) throws DataAccessException {
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
