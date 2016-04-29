package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.DbConnector;
import com.aziflaj.companies.data.model.Company;
import com.aziflaj.companies.data.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao implements BaseDao<Department> {
    private Connection connection;

    public DepartmentDao() throws SQLException {
        connection = DbConnector.getConnection();
    }


    @Override
    public List<Department> all() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT id, name, company_id FROM departments;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            departments.add(new Department(rs.getLong("id"),
                    rs.getString("name"),
                    Company.getById(connection, rs.getLong("company_id"))));
        }

        return departments;
    }

    @Override
    public Department getById(long id) throws SQLException {
        String query = "SELECT name, company_id FROM departments WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.first()) {
            return new Department(rs.getLong("id"),
                    rs.getString("name"),
                    Company.getById(connection, rs.getLong("company_id")));
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Department object) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Department object) throws SQLException {
        return false;
    }

    public List<Department> getByCompany(Company company) throws SQLException {
        List<Department> departments = new ArrayList<>();

        String departmentsSql = "SELECT id, name FROM departments WHERE company_id = ?;";
        PreparedStatement statement = connection.prepareStatement(departmentsSql);
        statement.setLong(1, company.getId());
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            departments.add(new Department(rs.getLong("id"),
                    rs.getString("name"),
                    company));
        }

        return departments;
    }
}
