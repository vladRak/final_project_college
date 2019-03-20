package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.UserDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.Privilege;
import com.final_project_college.dto.Role;
import com.final_project_college.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLUserDAO implements UserDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLUserDAO.class);

    public MySQLUserDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUnverifiedUsers() {
        return null;
    }

    @Override
    public Role getRoleByUserId(long userId) {
        return null;
    }

    @Override
    public List<Privilege> getPrivilegesByUserId(long userId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<User> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public User create(User entity) throws SQLException {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    private void setUserFieldsToStatement(PreparedStatement ps,
                                          User user) throws SQLException {
        ps.setString(1, user.getEMail());
        ps.setString(2, user.getPassword());
        ps.setBoolean(3, user.isVerified());
        ps.setBoolean(4, user.isBlocked());
        ps.setLong(5, user.getRoleId());
    }

    private User processUserRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("user.id");
        String eMail = rs.getString("user.e_mail");
        String password = rs.getString("user.password");
        boolean verified = rs.getBoolean("user.verified");
        boolean blocked = rs.getBoolean("user.blocked");
        long roleId = rs.getLong("user.role_id");

        return User.builder()
                .id(id)
                .eMail(eMail)
                .password(password)
                .verified(verified)
                .blocked(blocked)
                .roleId(roleId)
                .build();
    }
}
