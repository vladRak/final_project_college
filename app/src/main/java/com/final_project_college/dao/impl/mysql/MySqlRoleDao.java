package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.RoleDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Role;
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
    public Optional<Role> addPrivilegeToRole(long privilegeId, long roleId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Role> removePrivilegeFromRole(long privilegeId, long roleId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Role> getByRoleName(String roleName) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Role> getRolesByPrivilegeId(long privilegeId) throws SQLException {
        return null;
    }

    @Override
    public Optional<Role> getRoleByUserId(long userId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("role.count"));
    }

    @Override
    public List<Role> getAllPaginated(int start, int count) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("role.findAllPaginated"),
                (rs) -> Role.builder()
                        .id(rs.getLong("id"))
                        .roleName(rs.getString("role_name"))
                        .build(),
                start,
                count
        );
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("role.findAll"),
                (rs) -> Role.builder()
                        .id(rs.getLong("id"))
                        .roleName(rs.getString("role_name"))
                        .build());
    }

    @Override
    public Optional<Role> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("role.findById"),
                (rs) -> Role.builder()
                        .id(rs.getLong("id"))
                        .roleName(rs.getString("role_name"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("role.delete"));
    }

    @Override
    public boolean delete(Role entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public Role save(Role entity) throws SQLException {
        return Role.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("role.create")))
                .roleName(entity.getRoleName())
                .build();
    }

    @Override
    public Role update(Role entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("role.update"),
                entity.getRoleName(),
                entity.getId()
        );

        return entity;
    }
}
