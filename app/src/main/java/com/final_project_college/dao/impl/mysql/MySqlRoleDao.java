package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.RoleDao;
import com.final_project_college.dto.Role;
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
    public int getNumberOfRows() throws DataAccessException {
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
    public List<Role> findAllPaginated(int start, int count) throws DataAccessException {
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
    public List<Role> findAll() throws DataAccessException {
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
    public Optional<Role> getEntityById(long id) throws DataAccessException {
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
    public boolean deleteById(long id) throws DataAccessException {
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
    public Role create(Role entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("role.create"),
                    entity.getRoleName()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Role update(Role entity) throws DataAccessException {
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
