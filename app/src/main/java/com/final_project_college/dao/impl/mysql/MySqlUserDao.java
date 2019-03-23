package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.UserDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MySqlUserDao extends MySqlAbstractDao implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlUserDao.class);

    public MySqlUserDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<User> getByEmail(String email) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<User> getUnverifiedUsers() throws SQLException {
        return null;
    }

    @Override
    public List<User> getUsersByPrivilegeId(long privilegeId) throws SQLException {
        return null;
    }

    @Override
    public List<User> getUnverifiedUsersByPrivilegeId(long privilegeId) throws SQLException {
        return null;
    }

    @Override
    public List<User> getUsersByRoleId(long roleId) throws SQLException {
        return null;
    }

    @Override
    public List<User> getUnverifiedUsersByRoleId(long roleId) throws SQLException {
        return null;
    }

    @Override
    public int numberOfRows() throws SQLException {
        return getNumberOfRows(queryManager
                .getQuery("user.count"));
    }

    @Override
    public List<User> getAllPaginated(int start, int count) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("user.findAllPaginated"),
                (rs) -> User.builder()
                        .id(rs.getLong("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .eMail(rs.getString("e_mail"))
                        .password(rs.getString("password"))
                        .verified(rs.getBoolean("verified"))
                        .blocked(rs.getBoolean("blocked"))
                        .roleId(rs.getLong("role_id"))
                        .build(),
                start,
                count
        );
    }

    @Override
    public List<User> getAll() throws SQLException {
        return queryManager.select(
                queryManager.getQuery("user.findAll"),
                (rs) -> User.builder()
                        .id(rs.getLong("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .eMail(rs.getString("e_mail"))
                        .password(rs.getString("password"))
                        .verified(rs.getBoolean("verified"))
                        .blocked(rs.getBoolean("blocked"))
                        .roleId(rs.getLong("role_id"))
                        .build());
    }

    @Override
    public Optional<User> get(long id) throws SQLException {
        return queryManager.select(
                queryManager.getQuery("user.findById"),
                (rs) -> User.builder()
                        .id(rs.getLong("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .eMail(rs.getString("e_mail"))
                        .password(rs.getString("password"))
                        .verified(rs.getBoolean("verified"))
                        .blocked(rs.getBoolean("blocked"))
                        .roleId(rs.getLong("role_id"))
                        .build(),
                id).stream().findFirst();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return deleteById(id, queryManager
                .getQuery("user.delete"));
    }

    @Override
    public boolean delete(User entity) throws SQLException {
        return delete(entity.getId());
    }

    @Override
    public User save(User entity) throws SQLException {
        return User.builder()
                .id(queryManager.insertAndGetId(
                        queryManager.getQuery("user.create")))
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .eMail(entity.getEMail())
                .password(entity.getPassword())
                .verified(entity.isVerified())
                .blocked(entity.isBlocked())
                .roleId(entity.getRoleId())
                .build();
    }

    @Override
    public User update(User entity) throws SQLException {
        queryManager.update(
                queryManager.getQuery("user.update"),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEMail(),
                entity.getPassword(),
                entity.isVerified(),
                entity.isBlocked(),
                entity.getRoleId(),
                entity.getId()
        );

        return entity;
    }
}
