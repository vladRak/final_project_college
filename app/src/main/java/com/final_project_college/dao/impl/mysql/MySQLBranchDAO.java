package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.BranchDAO;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;
import com.final_project_college.dto.Branch;
import com.final_project_college.dto.College;
import com.final_project_college.dto.Specialty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLBranchDAO implements BranchDAO {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLBranchDAO.class);

    public MySQLBranchDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public List<Specialty> getSpecialtiesByBranchId(long branchId) {
        return null;
    }

    @Override
    public List<College> getCollegesByBranchId(long branchId) {
        return null;
    }

    @Override
    public int getNumberOfRows() {
        return 0;
    }

    @Override
    public List<Branch> findAllPaginated(int start, int count) {
        return null;
    }

    @Override
    public List<Branch> findAll() {
        return null;
    }

    @Override
    public Branch getEntityById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Branch create(Branch entity) throws SQLException {
        return null;
    }

    @Override
    public Branch update(Branch entity) {
        return null;
    }

    private void setBranchFieldsToStatement(PreparedStatement ps,
                                            Branch branch) throws SQLException {
        ps.setInt(1, branch.getBranchCode());
        ps.setString(2, branch.getBranchName());
        ps.setBigDecimal(3, branch.getCoefficient());

    }

    private Branch processBranchRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("branch.id");
        short branchCode = rs.getShort("branch.branch_code");
        String branchName = rs.getString("branch.branch_name");
        BigDecimal branchCoefficient = rs.getBigDecimal("branch.branch_coefficient");

        return Branch.builder()
                .id(id)
                .branchCode(branchCode)
                .branchName(branchName)
                .branchCoefficient(branchCoefficient)
                .build();
    }
}
