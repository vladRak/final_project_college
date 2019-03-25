package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.RoleDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlRoleDao extends MySqlAbstractDao implements RoleDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlRoleDao.class);

    public MySqlRoleDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<Role> getByRoleName(String roleName) {
        return Optional.empty();
    }

    @Override
    public Optional<Role> getRoleByUserId(long userId) {
        return Optional.empty();
    }

    @Override
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("role.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Role> getAllPaginated(int start, int count) {
        try {
            return queryManager.select(
                    queryManager.getQuery("role.findAllPaginated"),
                    (rs) -> Role.builder()
                            .id(rs.getLong("id"))
                            .roleName(rs.getString("role_name"))
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
    public List<Role> getAll() {
        try {
            return queryManager.select(
                    queryManager.getQuery("role.findAll"),
                    (rs) -> Role.builder()
                            .id(rs.getLong("id"))
                            .roleName(rs.getString("role_name"))
                            .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Role> get(long id) {
        try {
            return queryManager.select(
                    queryManager.getQuery("role.findById"),
                    (rs) -> Role.builder()
                            .id(rs.getLong("id"))
                            .roleName(rs.getString("role_name"))
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
                    .getQuery("role.delete"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Role entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<Role> save(Role entity) {
        try {

            entity.setId(
                    queryManager.insertAndGetId(
                            queryManager.getQuery("role.create"),
                            entity.getRoleName()
                    ));
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Role> update(Role entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("role.update"),
                    entity.getRoleName(),
                    entity.getId()
            );
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
