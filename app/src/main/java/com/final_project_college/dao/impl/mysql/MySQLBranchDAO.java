package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.BranchDAO;
import com.final_project_college.dto.Branch;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySQLBranchDAO extends MySQLAbstractDAO implements BranchDAO {

    private static final Logger logger = LoggerFactory.getLogger(MySQLBranchDAO.class);

    public MySQLBranchDAO(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("branch.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Branch> findAllPaginated(int start, int count) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("branch.findAllPaginated"),
                    (rs) -> Branch.builder()
                            .id(rs.getLong("id"))
                            .branchCode(rs.getShort("branch_code"))
                            .branchName(rs.getString("branch_name"))
                            .branchCoefficient(rs.getBigDecimal("branch_coefficient"))
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
    public List<Branch> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("branch.findAll"),
                    (rs) -> Branch.builder()
                            .id(rs.getLong("id"))
                            .branchCode(rs.getShort("branch_code"))
                            .branchName(rs.getString("branch_name"))
                            .branchCoefficient(rs.getBigDecimal("branch_coefficient"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<Branch> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("branch.findById"),
                    (rs) -> Branch.builder()
                            .id(rs.getLong("id"))
                            .branchCode(rs.getShort("branch_code"))
                            .branchName(rs.getString("branch_name"))
                            .branchCoefficient(rs.getBigDecimal("branch_coefficient"))
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
                    .getQuery("branch.deleteById"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Branch create(Branch entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("branch.create"),
                    entity.getBranchCode(),
                    entity.getBranchName(),
                    entity.getCoefficient()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Branch update(Branch entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("branch.update"),
                    entity.getBranchCode(),
                    entity.getBranchName(),
                    entity.getCoefficient(),
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
