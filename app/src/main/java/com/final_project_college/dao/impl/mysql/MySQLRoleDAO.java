package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.RoleDAO;
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

public class MySQLRoleDAO implements RoleDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLRoleDAO.class);

    public MySQLRoleDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public Role addPrivilegeToRole(long privilegeId, long roleId) {
        return null;
    }

    @Override
    public Role removePrivilegeFromRole(long privilegeId, long roleId) {
        return null;
    }

    @Override
    public Role getByRoleName(String roleName) {
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
    public List<Privilege> getPrivilegesByRoleId(long roleId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<Role> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Role create(Role entity) throws SQLException {
        return null;
    }

    @Override
    public Role update(Role entity) {
        return null;
    }

    private void setRoleFieldsToStatement(PreparedStatement ps,
                                          Role role) throws SQLException {
        ps.setString(1, role.getRoleName());
    }

    private Role processRoleRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("role.id");
        String roleName = rs.getString("role.role_name");

        return Role.builder()
                .id(id)
                .roleName(roleName)
                .build();
    }
}
