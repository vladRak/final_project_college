package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.dao.UserDao;
import com.final_project_college.persistence.dto.User;
import com.final_project_college.exception.DataAccessException;
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
    public Optional<User> getByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> getUnverifiedUsers() {
        return null;
    }

    @Override
    public List<User> getUsersByPrivilegeId(long privilegeId) {
        return null;
    }

    @Override
    public List<User> getUnverifiedUsersByPrivilegeId(long privilegeId) {
        return null;
    }

    @Override
    public List<User> getUsersByRoleId(long roleId) {
        return null;
    }

    @Override
    public List<User> getUnverifiedUsersByRoleId(long roleId) {
        return null;
    }

    @Override
    public int getNumberOfRows() throws DataAccessException {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("user.count"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<User> findAllPaginated(int start, int count) throws DataAccessException {
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<User> findAll() throws DataAccessException {
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Optional<User> getEntityById(long id) throws DataAccessException {
        try {
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
                    .getQuery("user.delete"));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public User create(User entity) throws DataAccessException {
        try {
            entity.setId(queryManager.insertAndGetId(
                    queryManager.getQuery("user.create"),
                    entity.getFirstName(),
                    entity.getLastName(),
                    entity.getEMail(),
                    entity.getPassword(),
                    entity.isVerified(),
                    entity.isBlocked(),
                    entity.getRoleId()
            ));

            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public User update(User entity) throws DataAccessException {
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new DataAccessException(e.getMessage());
        }
    }
}
