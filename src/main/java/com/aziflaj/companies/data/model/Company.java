package com.aziflaj.companies.data.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Company {
    private long id; // Autoincrement
    private String nipt; // unique
    private String name;
    private String email; // unique
    private String password;
    private String address;

    public Company(long id, String nipt, String name, String address, String email, String password) {
        this.id = id;
        this.nipt = nipt;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public static Company getByEmail(Connection conn, String email) throws SQLException {
        String selectQuery = "SELECT id, nipt, name, address, email, password " +
                "FROM companies " +
                "WHERE email = ?;";
        PreparedStatement stmt = conn.prepareStatement(selectQuery);
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
            System.out.printf("No company with email %s found", email);
            return null;
        }
    }

    public static Company getById(Connection conn, long id) {
        // TODO: implement
        return null;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public String getNipt() {
        return nipt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}