package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.PrivilegeDAO;
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

public class MySQLPrivilegeDAO implements PrivilegeDAO {


    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLPrivilegeDAO.class);

    public MySQLPrivilegeDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public Privilege addRoleToPrivilege(long roleId, long privilegeId) {
        return null;
    }

    @Override
    public Privilege removeRoleFromPrivilege(long roleId, long privilegeId) {
        return null;
    }

    @Override
    public Privilege getByPrivilegeName(String roleName) {
        return null;
    }

    @Override
    public List<Role> getRolesByPrivilegeId(long privilegeId) {
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
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<Privilege> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Privilege> findAll() {
        return null;
    }

    @Override
    public Privilege getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Privilege create(Privilege entity) throws SQLException {
        return null;
    }

    @Override
    public Privilege update(Privilege entity) {
        return null;
    }

    private void setPrivilegeFieldsToStatement(PreparedStatement ps,
                                               Privilege privilege) throws SQLException {
        ps.setString(1, privilege.getPrivilegeName());
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
