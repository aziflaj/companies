package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.model.Salary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalaryDao extends BaseDao<Salary> {
    public SalaryDao() throws SQLException {
        super();
    }

    @Override
    public List<Salary> all() throws SQLException {
        List<Salary> salaries = new ArrayList<>();
        String query = "SELECT id, value FROM salaries;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            salaries.add(new Salary(rs.getLong("id"),
                    rs.getDouble("value")));
        }

        return salaries;
    }

    @Override
    public Salary getById(long id) throws SQLException {
        String query = "SELECT value FROM salaries WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.first()) {
            return new Salary(id,
                    rs.getDouble("value"));
        } else {
            return null;
        }
    }

    @Override
    public Salary insert(Salary salary) throws SQLException {
        String query = "INSERT INTO salaries (value) " +
                "VALUES (?);";
        PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, salary.getSalary());

        if (statement.executeUpdate() == 1) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.first()) {
                long id = rs.getLong(1);
                salary.setId(id);
                return salary;
            }
        }
        return null;
    }

    @Override
    public boolean update(Salary salary) throws SQLException {
        String query = "UPDATE salaries SET value = ? WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setDouble(1, salary.getSalary());
        statement.setLong(2, salary.getId());

        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean delete(Salary salary) throws SQLException {
        String query = "DELETE FROM salaries WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, salary.getId());

        return statement.executeUpdate() == 1;
    }
}
