package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.model.Office;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OfficeDao extends BaseDao<Office> {
    public OfficeDao() throws SQLException {
        super();
    }

    @Override
    public List<Office> all() throws SQLException {
        List<Office> offices = new ArrayList<>();
        String query = "SELECT id, tables, pc_count, laptops, chairs, windows, books, " +
                "pencils, pens FROM offices;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            offices.add(new Office(rs.getLong("id"),
                    rs.getInt("tables"),
                    rs.getInt("pc_count"),
                    rs.getInt("laptops"),
                    rs.getInt("chairs"),
                    rs.getInt("windows"),
                    rs.getInt("books"),
                    rs.getInt("pencils"),
                    rs.getInt("pens")));
        }

        return offices;
    }

    @Override
    public Office getById(long id) throws SQLException {
        String selectQuery = "SELECT tables, pc_count, laptops, chairs, windows, books, pencils, pens "
                + "FROM companies_db.offices "
                + "WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement(selectQuery);
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.first()) {
            return new Office(id,
                    rs.getInt("tables"),
                    rs.getInt("pc_count"),
                    rs.getInt("laptops"),
                    rs.getInt("chairs"),
                    rs.getInt("windows"),
                    rs.getInt("books"),
                    rs.getInt("pencils"),
                    rs.getInt("pens"));
        } else {
            return null;
        }
    }

    @Override
    public Office insert(Office office) throws SQLException {
        String query = "INSERT INTO offices " +
                "(tables, pc_count, laptops, chairs, windows, books, pencils, pens) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, office.getTables());
        statement.setInt(2, office.getPersonalComputers());
        statement.setInt(3, office.getLaptops());
        statement.setInt(4, office.getChairs());
        statement.setInt(5, office.getWindows());
        statement.setInt(6, office.getBooks());
        statement.setInt(7, office.getPencils());
        statement.setInt(8, office.getPens());

        if (statement.executeUpdate() == 1) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.first()) {
                long id = rs.getLong(1);
                office.setId(id);
                return office;
            }
        }
        return null;
    }

    @Override
    public boolean update(Office office) throws SQLException {
        String query = "UPDATE offices " +
                "SET tables =  ?, pc_count = ?, laptops = ?, chairs = ?, windows = ?, " +
                "books = ?, pencils = ?, pens = ? " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, office.getTables());
        statement.setInt(2, office.getPersonalComputers());
        statement.setInt(3, office.getLaptops());
        statement.setInt(4, office.getChairs());
        statement.setInt(5, office.getWindows());
        statement.setInt(6, office.getBooks());
        statement.setInt(7, office.getPencils());
        statement.setInt(8, office.getPens());

        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean delete(Office office) throws SQLException {
        String query = "DELETE FROM offices " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, office.getId());

        return statement.executeUpdate() == 1;
    }
}
