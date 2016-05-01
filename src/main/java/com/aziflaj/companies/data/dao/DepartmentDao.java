package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.model.Company;
import com.aziflaj.companies.data.model.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao extends BaseDao<Department> {
    private CompanyDao companyDao;

    public DepartmentDao() throws SQLException {
        super();
        companyDao = new CompanyDao();
    }

    @Override
    public List<Department> all() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT id, name, company_id FROM departments;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            departments.add(new Department(rs.getLong("id"),
                    rs.getString("name"),
                    companyDao.getById(rs.getLong("company_id"))));
        }

        return departments;
    }

    @Override
    public Department getById(long id) throws SQLException {
        String query = "SELECT name, company_id FROM departments WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.first()) {
            return new Department(id,
                    rs.getString("name"),
                    companyDao.getById(rs.getLong("company_id")));
        } else {
            return null;
        }
    }

    @Override
    public Department insert(Department department) throws SQLException {
        String query = "INSERT INTO departments (name, company_id) " +
                "VALUES (?, ?);";
        PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, department.getName());
        statement.setLong(2, department.getCompany().getId());

        if (statement.executeUpdate() == 1) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.first()) {
                long id = rs.getLong(1);
                department.setId(id);
                return department;
            }
        }
        return null;
    }

    @Override
    public boolean update(Department department) throws SQLException {
        String query = "UPDATE departments " +
                "SET name =  ?, company_id = ? " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, department.getName());
        statement.setLong(2, department.getCompany().getId());
        statement.setLong(3, department.getId());

        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean delete(Department department) throws SQLException {
        String query = "DELETE FROM departments " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, department.getId());

        return statement.executeUpdate() == 1;
    }

    public List<Department> getByCompany(Company company) throws SQLException {
        List<Department> departments = new ArrayList<>();

        String query = "SELECT id, name FROM departments WHERE company_id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
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
