package com.aziflaj.companies.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            String host = "jdbc:mysql://localhost:33060/companies_db?serverTimezone=UTC";
            String username = "masteruser";
            String password = "password";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(host, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }
}