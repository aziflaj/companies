package com.aziflaj.companies.data;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnector {
    private static final String DATABASE_PROPERTIES_FILE = "database.properties";
    private static final String DB_HOST_FORMAT = "jdbc:mysql://%s:%s/%s?serverTimezone=UTC";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                URL resourceUrl = DbConnector.class.getClassLoader()
                        .getResource(DATABASE_PROPERTIES_FILE);

                if (resourceUrl == null) {
                    System.out.println("Error while reading database credentials from database.properties");
                } else {
                    Properties dbProperties = new Properties();
                    dbProperties.load(new FileReader(resourceUrl.getFile()));
                    String username = dbProperties.getProperty("username");
                    String password = dbProperties.getProperty("password");
                    String host = String.format(DB_HOST_FORMAT,
                            dbProperties.getProperty("database_host"),
                            dbProperties.getProperty("database_port"),
                            dbProperties.getProperty("database_name"));

                    connection = DriverManager.getConnection(host, username, password);
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }
}