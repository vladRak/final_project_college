package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.UserDao;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;
import com.final_project_college.domain.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlUserDao extends MySqlAbstractDao implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlUserDao.class);

    public MySqlUserDao(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        try {
            return queryManager.select(
                    queryManager.getQuery("user.findByEmail"),
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
                    email).stream().findFirst();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> getByEmailAndPassword(String email, String password) {
        try {
            return queryManager.select(
                    queryManager.getQuery("user.findByEmailAndPassword"),
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
                    email).stream().findFirst();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> getUserByVerificationHash(String hash) {
        try {
            return queryManager.select(
                    queryManager.getQuery("user.findUserByVerificationHash"),
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
                    hash).stream().findFirst();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteVerificationHashByUserId(long userId) {
        try {
            return deleteById(userId, queryManager
                    .getQuery("user.deleteVerificationHashByUserId"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<String> saveVerificationHash(long userId, String hash) {
        try {
            if (userId == queryManager.insertAndGetId(
                    queryManager.getQuery("user.createVerificationHash"),
                    userId,
                    hash))
                return Optional.of(hash);
            else return Optional.empty();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<User> getUnverifiedUsersPaginated(int start, int count) {
        try {
            return queryManager.select(
                    queryManager.getQuery("user.findUnverifiedUsersPaginated"),
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
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<User> getUnverifiedUsersByRoleId(long roleId) {
        try {
            return queryManager.select(
                    queryManager.getQuery("user.findUnverifiedUsersByRoleId"),
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
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<User> getUsersByRoleId(long roleId) {
        try {
            return queryManager.select(
                    queryManager.getQuery("user.findByRoleId"),
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
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public int numberOfRows() {
        try {
            return getNumberOfRows(queryManager
                    .getQuery("user.count"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<User> getAllPaginated(int start, int count) {
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
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<User> getAll() {
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
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<User> get(long id) {
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
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            return deleteById(id, queryManager
                    .getQuery("user.delete"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(User entity) {
        return delete(entity.getId());
    }

    @Override
    public Optional<User> save(User entity) {
        try {
            entity.setId(
                    queryManager.insertAndGetId(
                            queryManager.getQuery("user.create"),
                            entity.getFirstName(),
                            entity.getLastName(),
                            entity.getEMail(),
                            entity.getPassword(),
                            entity.isVerified(),
                            entity.isBlocked(),
                            entity.getRoleId()
                    ));
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> update(User entity) {
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
            return Optional.of(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
