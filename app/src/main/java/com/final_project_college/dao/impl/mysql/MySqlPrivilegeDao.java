package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.PrivilegeDao;
import com.final_project_college.persistence.dto.Privilege;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlPrivilegeDao extends MySqlAbstractDao implements PrivilegeDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlPrivilegeDao.class);

    public MySqlPrivilegeDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<Privilege> addRoleToPrivilege(long roleId, long privilegeId) {
        return Optional.empty();
    }

    @Override
    public Optional<Privilege> removeRoleFromPrivilege(long roleId, long privilegeId) {
        return Optional.empty();
    }

    @Override
    public Optional<Privilege> getByPrivilegeName(String roleName) {
        return Optional.empty();
    }

    @Override
    public List<Privilege> getPrivilegesByRoleId(long roleId) {
        return null;
    }

    @Override
    public List<Privilege> getPrivilegesByUserId(long userId) {
        return null;
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("privilege.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Privilege> findAllPaginated(int start, int count) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("privilege.findAllPaginated"),
                    (rs) -> Privilege.builder()
                            .id(rs.getLong("id"))
                            .privilegeName(rs.getString("privilege_name"))
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
    public List<Privilege> findAll() throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("privilege.findAll"),
                    (rs) -> Privilege.builder()
                            .id(rs.getLong("id"))
                            .privilegeName(rs.getString("privilege_name"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<Privilege> getEntityById(long id) throws DataAccessException {
        try {
            return queryManager.select(
                    queryManager.getQuery("privilege.findById"),
                    (rs) -> Privilege.builder()
                            .id(rs.getLong("id"))
                            .privilegeName(rs.getString("privilege_name"))
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
                    .getQuery("privilege.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Privilege create(Privilege entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("privilege.create"),
                    entity.getPrivilegeName()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Privilege update(Privilege entity) throws DataAccessException {
        try {
            queryManager.update(
                    queryManager.getQuery("privilege.update"),
                    entity.getPrivilegeName(),
                    entity.getId()
            );

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    private Privilege processPrivilegeRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("privilege.id");
        String privilegeName = rs.getString("privilege.privilege_name");

        return Privilege.builder()
                .id(id)
                .privilegeName(privilegeName)
                .build();
    }
}
