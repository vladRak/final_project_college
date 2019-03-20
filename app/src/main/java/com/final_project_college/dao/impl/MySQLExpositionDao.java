package com.final_project_college.dao.impl;

import com.final_project.connection.ConnectionWrapper;
import com.final_project.dao.ExpositionDao;
import com.final_project.dao.util.QueryManager;
import com.final_project.dao.util.impl.QueryManagerImpl;
import com.final_project.dto.Exposition;
import com.final_project.external_config.FileExternalConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySQLExpositionDao implements ExpositionDao {

    private final QueryManager queryManager;
    private final ConnectionWrapper connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLExpositionDao.class);

    public MySQLExpositionDao(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl();
    }

    @Override
    public List<Exposition> getByAllFieldsWithDate(String field, Date date) {
        String sql = queryManager.getQuery("exposition.findByAllFieldsWithDate");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, field);
            ps.setString(2, field);
            ps.setString(3, field);
            ps.setDate(4, date);
            ps.setDate(5, date);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> getByAllFields(String field) {
        String sql = queryManager.getQuery("exposition.findByAllFields");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, field);
            ps.setString(2, field);
            ps.setString(3, field);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> getByName(String name) {
//        String sql = queryManager.getQuery("exposition.findByTitle");
        String sql = queryManager.getQuery("exposition.findByName");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> getByTitle(String title) {
        String sql = queryManager.getQuery("exposition.findByAllFields");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, title);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> getByTheme(String theme) {
        String sql = queryManager.getQuery("exposition.findByTheme");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, theme);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> getByDate(Date date) {
        String sql = queryManager.getQuery("exposition.findByDate");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, date);
            ps.setDate(2, date);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> getByPrice(int price) {
        String sql = queryManager.getQuery("exposition.findByPrice");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, price);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> getByTicketsAvailable(int ticketsAvailable) {
        String sql = queryManager.getQuery("exposition.findByTicketsAvailable");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, ticketsAvailable);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> getByHallId(long hallId) {
        String sql = queryManager.getQuery("exposition.findByHall");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, hallId);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public int getNumberOfRows() {
        int numOfRows = 0;

        String sql = queryManager.getQuery("exposition.count");
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    numOfRows = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return numOfRows;
    }

    @Override
    public List<Exposition> findAllPaginated(int start, int count) {
        String sql = queryManager.getQuery("exposition.findAllPaginated");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public List<Exposition> findAll() {
        String sql = queryManager.getQuery("exposition.findAll");
        List<Exposition> list = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(processExpositionRow(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        if (list == null) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    public Exposition getEntityById(Long id) {
        String sql = queryManager.getQuery("exposition.findById");
        Exposition exposition = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    exposition = processExpositionRow(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        if (exposition == null) {
            exposition = new Exposition().getEmptyExposition();
        }

        return exposition;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = queryManager.getQuery("exposition.deleteById");
        boolean deleted = false;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            int i = ps.executeUpdate();
            if (i > 0) deleted = true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());

        }
        return deleted;
    }

    @Override
    public Exposition create(Exposition entity) throws SQLException {
        String sql = queryManager.getQuery("exposition.create");
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setExpositionFieldsToStatement(ps, entity);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating exposition failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating exposition failed, no ID obtained.");
                }
            }
        }
        return entity;
    }

    @Override
    public Exposition update(Exposition entity) {
        String sql = queryManager.getQuery("exposition.update");
        Exposition updated = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            setExpositionFieldsToStatement(ps, entity);
            ps.setLong(10, entity.getId());
            int i = ps.executeUpdate();
            if (i > 0) updated = entity;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return updated;
    }

    private void setExpositionFieldsToStatement(PreparedStatement ps, Exposition exposition) throws SQLException {
        ps.setDate(1, exposition.getDateStart());
        ps.setDate(2, exposition.getDateEnd());
        ps.setString(3, exposition.getDescription());
        ps.setString(4, exposition.getName());
        ps.setBigDecimal(5, exposition.getPrice());
        ps.setString(6, exposition.getTheme());
        ps.setInt(7, exposition.getTicketsAvailable());
        ps.setString(8, exposition.getTitle());
        ps.setLong(9, exposition.getHallId());
    }

    private Exposition processExpositionRow(ResultSet rs) throws SQLException {
        final long id = rs.getLong("exposition.id");
        Date dateStart = rs.getDate("exposition.date_start");
        Date dateEnd = rs.getDate("exposition.date_end");
        String description = rs.getString("exposition.description");
        String name = rs.getString("exposition.name");
        BigDecimal price = rs.getBigDecimal("exposition.price");
        String theme = rs.getString("exposition.theme");
        int ticketsAvailable = rs.getInt("exposition.tickets_available");
        String title = rs.getString("exposition.title");
        final long hallId = rs.getLong("exposition.hall_id");

        return Exposition.builder()
                .id(id)
                .dateStart(dateStart)
                .dateEnd(dateEnd)
                .description(description)
                .name(name)
                .price(price)
                .theme(theme)
                .ticketsAvailable(ticketsAvailable)
                .title(title)
                .hallId(hallId)
                .build();
    }
}
