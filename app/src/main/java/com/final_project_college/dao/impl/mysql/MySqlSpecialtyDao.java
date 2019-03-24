package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.SpecialtyDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Specialty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
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
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("specialty.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
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
                            .governmentOrder(rs.getInt("government_order"))
                            .contractOrder(rs.getInt("contract_order"))
                            .build(),
                    start,
                    count
            );
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
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
                            .governmentOrder(rs.getInt("government_order"))
                            .contractOrder(rs.getInt("contract_order"))
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
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
                            .governmentOrder(rs.getInt("government_order"))
                            .contractOrder(rs.getInt("contract_order"))
                            .build(),
                    id).stream().findFirst();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            return deleteById(id, queryManager
                    .getQuery("specialty.delete"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean delete(Specialty entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<Specialty> save(Specialty entity) {
        try {
            return Optional.of(
                    Specialty.builder()
                            .id(queryManager.insertAndGetId(
                                    queryManager.getQuery("specialty.create")))
                            .specialtyName(entity.getSpecialtyName())
                            .governmentOrder(entity.getGovernmentOrder())
                            .contractOrder(entity.getContractOrder())
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Specialty> update(Specialty entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("specialty.update"),
                    entity.getSpecialtyName(),
                    entity.getGovernmentOrder(),
                    entity.getContractOrder(),
                    entity.getId()
            );
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
