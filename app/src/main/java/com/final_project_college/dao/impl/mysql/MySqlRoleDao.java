package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.RoleDao;
import com.final_project_college.domain.dto.Role;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlRoleDao extends MySqlAbstractDao implements RoleDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlRoleDao.class);

    public MySqlRoleDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<Role> addPrivilegeToRole(long privilegeId, long roleId) {
        return Optional.empty();
    }

    @Override
    public Optional<Role> removePrivilegeFromRole(long privilegeId, long roleId) {
        return Optional.empty();
    }

    @Override
    public Optional<Role> getByRoleName(String roleName) {
        return Optional.empty();
    }

    @Override
    public List<Role> getRolesByPrivilegeId(long privilegeId) {
        return null;
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
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
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
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
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
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
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
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean delete(long id) {
        try {

            return deleteById(id, queryManager
                    .getQuery("role.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Role entity) {
        return delete(entity.getId());
    }

    @Override
    public Role save(Role entity) {
        try {
            return Role.builder()
                    .id(queryManager.insertAndGetId(
                            queryManager.getQuery("role.create")))
                    .roleName(entity.getRoleName())
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Role update(Role entity) {
        try {
            queryManager.update(
                    queryManager.getQuery("role.update"),
                    entity.getRoleName(),
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
