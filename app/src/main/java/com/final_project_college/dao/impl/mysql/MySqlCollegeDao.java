package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.CollegeDao;
import com.final_project_college.persistence.dto.College;
import com.final_project_college.exception.DataAccessException;
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
    public List<College> getCollegesByName(String collegeName) {
        return null;
    }

    @Override
    public List<College> getCollegesBySpecialtyId(long specialtyId) {
        return null;
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("college.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<College> findAllPaginated(int start, int count) throws DataAccessException {
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<College> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("college.findAll"),
                    (rs) -> College.builder()
                            .id(rs.getLong("id"))
                            .name(rs.getString("college_name"))
                            .description(rs.getString("college_description"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<College> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("college.findById"),
                    (rs) -> College.builder()
                            .id(rs.getLong("id"))
                            .name(rs.getString("college_name"))
                            .description(rs.getString("college_description"))
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
                    .getQuery("college.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public College create(College entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("college.create"),
                    entity.getName(),
                    entity.getDescription()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public College update(College entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("college.update"),
                    entity.getName(),
                    entity.getDescription(),
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
