package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.PrivilegeDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.Privilege;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlPrivilegeDao extends MySqlAbstractDao implements PrivilegeDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlPrivilegeDao.class);

    public MySqlPrivilegeDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<Privilege> addRoleToPrivilege(long roleId, long privilegeId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Privilege> removeRoleFromPrivilege(long roleId, long privilegeId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Privilege> getByPrivilegeName(String roleName) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Privilege> getPrivilegesByRoleId(long roleId) throws SQLException {
        return null;
    }

    @Override
    public List<Privilege> getPrivilegesByUserId(long userId) throws SQLException {
        return null;
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("privilege.count"));
    }

    @Override
    public List<Privilege> getAllPaginated(int start, int count) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("privilege.findAllPaginated"),
                (rs) -> Privilege.builder()
                        .id(rs.getLong("id"))
                        .privilegeName(rs.getString("privilege_name"))
                        .build(),
                start,
                count
        );
    }

    @Override
    public List<Privilege> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("privilege.findAll"),
                (rs) -> Privilege.builder()
                        .id(rs.getLong("id"))
                        .privilegeName(rs.getString("privilege_name"))
                        .build());
    }

    @Override
    public Optional<Privilege> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("privilege.findById"),
                (rs) -> Privilege.builder()
                        .id(rs.getLong("id"))
                        .privilegeName(rs.getString("privilege_name"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("privilege.delete"));
    }

    @Override
    public boolean delete(Privilege entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public Privilege save(Privilege entity) throws SQLException {
        return Privilege.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("privilege.create")))
                .privilegeName(entity.getPrivilegeName())
                .build();
    }

    @Override
    public Privilege update(Privilege entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("privilege.update"),
                entity.getPrivilegeName(),
                entity.getId()
        );

        return entity;
    }
}
