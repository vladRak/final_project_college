package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.CollegeSpecialtyDAO;
import com.final_project_college.dto.CollegeSpecialty;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class MySQLCollegeSpecialtyDAO extends MySQLAbstractDAO implements CollegeSpecialtyDAO {

    private static final Logger logger = LoggerFactory.getLogger(MySQLCollegeSpecialtyDAO.class);

    public MySQLCollegeSpecialtyDAO(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public List<CollegeSpecialty> getCollegeSpecialtiesByCollegeId(long collegeId) {
        return null;
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        return 0;
    }

    @Override
    public List<CollegeSpecialty> findAllPaginated(int start, int count) throws DataAccessException {
        return null;
    }

    @Override
    public List<CollegeSpecialty> findAll() throws DataAccessException {
        return null;
    }

    @Override
    public Optional<CollegeSpecialty> getEntityById(long id) throws DataAccessException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(long id) throws DataAccessException {
        return false;
    }

    @Override
    public CollegeSpecialty create(CollegeSpecialty entity) throws DataAccessException {
        return null;
    }

    @Override
    public CollegeSpecialty update(CollegeSpecialty entity) throws DataAccessException {
        return null;
    }
}
