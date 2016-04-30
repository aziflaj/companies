package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.model.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao extends BaseDao<Company> {

    public CompanyDao() throws SQLException {
        super();
    }

    @Override
    public List<Company> all() throws SQLException {
        List<Company> companies = new ArrayList<>();
        String query = "SELECT id, nipt, name, email, password, address FROM companies;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            companies.add(new Company(rs.getLong("id"),
                    rs.getString("nipt"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("password")));
        }

        return companies;
    }

    @Override
    public Company getById(long id) throws SQLException {
        String query = "SELECT nipt, name, email, password, address FROM companies WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.first()) {
            return new Company(id,
                    rs.getString("nipt"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("password"));
        } else {
            return null;
        }
    }

    @Override
    public Company insert(Company company) throws SQLException {
        String query = "INSERT INTO companies (nipt, name, email, password, address) " +
                "VALUES (?, ?, ?, ?, ?);";
        PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, company.getNipt());
        statement.setString(2, company.getName());
        statement.setString(3, company.getEmail());
        statement.setString(4, company.getPassword());
        statement.setString(5, company.getAddress());

        if (statement.executeUpdate() == 1) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.first()) {
                long id = rs.getLong(1);
                company.setId(id);
                return company;
            }
        }
        return null;
    }

    @Override
    public boolean update(Company company) throws SQLException {
        String query = "UPDATE companies " +
                "SET name =  ?, email = ?, password = ?, address = ? " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, company.getName());
        statement.setString(2, company.getEmail());
        statement.setString(3, company.getPassword());
        statement.setString(4, company.getAddress());
        statement.setLong(5, company.getId());

        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean delete(Company company) throws SQLException {
        String query = "DELETE FROM companies WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, company.getId());

        return statement.executeUpdate() == 1;
    }

    public Company getByEmail(String email) throws SQLException {
        String selectQuery = "SELECT id, nipt, name, address, email, password " +
                "FROM companies " +
                "WHERE email = ?;";
        PreparedStatement stmt = getConnection().prepareStatement(selectQuery);
        stmt.setString(1, email);

        ResultSet rs = stmt.executeQuery();
        if (rs.first()) {
            return new Company(rs.getLong("id"),
                    rs.getString("nipt"),
                    rs.getString("name"),
                    rs.getString("address"),
                    email,
                    rs.getString("password"));
        } else {
            return null;
        }
    }
}
