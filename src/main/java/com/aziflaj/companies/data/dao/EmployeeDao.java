package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends BaseDao<Employee> {
    private RoleDao roleDao;
    private SectorDao sectorDao;

    public EmployeeDao() throws SQLException {
        super();
        roleDao = new RoleDao();
        sectorDao = new SectorDao();
    }

    @Override
    public List<Employee> all() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT id, full_name, ssn, email, dob, role_id, sector_id FROM employees;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            employees.add(new Employee(rs.getLong("id"),
                    rs.getString("full_name"),
                    rs.getString("ssn"),
                    rs.getString("email"),
                    rs.getDate("dob"),
                    roleDao.getById(rs.getLong("role_id")),
                    sectorDao.getById(rs.getLong("sector_id"))));
        }

        return employees;
    }

    @Override
    public Employee getById(long id) throws SQLException {
        String query = "SELECT full_name, ssn, email, dob, role_id, sector_id " +
                "FROM employees " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.first()) {
            return new Employee(id,
                    rs.getString("full_name"),
                    rs.getString("ssn"),
                    rs.getString("email"),
                    rs.getDate("dob"),
                    roleDao.getById(rs.getLong("role_id")),
                    sectorDao.getById(rs.getLong("sector_id")));
        } else {
            return null;
        }
    }

    @Override
    public Employee insert(Employee employee) throws SQLException {
        String query = "INSERT INTO employees (full_name, ssn, email, dob, role_id, sector_id) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, employee.getFullName());
        statement.setString(2, employee.getSocialSecurityNumber());
        statement.setString(3, employee.getEmail());
        statement.setDate(4, new java.sql.Date(employee.getDateOfBirth().getTime()));
        statement.setLong(5, employee.getRole().getId());
        statement.setLong(6, employee.getSector().getId());

        if (statement.executeUpdate() == 1) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.first()) {
                long id = rs.getLong(1);
                employee.setId(id);
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        String query = "UPDATE employees " +
                "SET full_name = ?, ssn = ?, email = ?, dob = ?, role_id = ?, sector_id = ? " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, employee.getFullName());
        statement.setString(2, employee.getSocialSecurityNumber());
        statement.setString(3, employee.getEmail());
        statement.setDate(4, new java.sql.Date(employee.getDateOfBirth().getTime()));
        statement.setLong(5, employee.getRole().getId());
        statement.setLong(6, employee.getSector().getId());
        statement.setLong(7, employee.getId());

        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean delete(Employee employee) throws SQLException {
        String query = "DELETE FROM employees " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, employee.getId());

        return statement.executeUpdate() == 1;
    }
}
