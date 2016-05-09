package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends BaseDao<Role> {
    private SalaryDao salaryDao;

    public RoleDao() throws SQLException {
        super();
        salaryDao = new SalaryDao();
    }

    @Override
    public List<Role> all() throws SQLException {
        List<Role> roles = new ArrayList<>();
        String query = "SELECT id, name, salary_id FROM roles;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            roles.add(new Role(rs.getLong("id"),
                    rs.getString("name"),
                    salaryDao.getById(rs.getLong("salary_id"))));
        }

        return roles;
    }

    @Override
    public Role getById(long id) throws SQLException {
        String query = "SELECT name, salary_id FROM roles WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.first()) {
            return new Role(id,
                    rs.getString("name"),
                    salaryDao.getById(rs.getLong("salary_id")));
        } else {
            return null;
        }
    }

    @Override
    public Role insert(Role role) throws SQLException {
        String query = "INSERT INTO roles (name, salary_id) " +
                "VALUES (?, ?);";
        PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, role.getName());
        statement.setLong(2, role.getSalary().getId());

        if (statement.executeUpdate() == 1) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.first()) {
                long id = rs.getLong(1);
                role.setId(id);
                return role;
            }
        }
        return null;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String query = "UPDATE roles SET name = ?, salary_id = ? WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, role.getName());
        statement.setLong(2, role.getSalary().getId());
        statement.setLong(3, role.getId());

        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String query = "DELETE FROM roles WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, role.getId());

        return statement.executeUpdate() == 1;
    }

    public Role getByName(String name) throws SQLException {
        String query = "SELECT id, salary_id FROM roles WHERE name = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();

        if (rs.first()) {
            return new Role(rs.getLong("id"),
                    name,
                    salaryDao.getById(rs.getLong("salary_id")));
        } else {
            return null;
        }
    }
}
