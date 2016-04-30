package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.DbConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {
    private Connection connection;

    public BaseDao() throws SQLException {
        connection = DbConnector.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public abstract List<T> all() throws SQLException;

    public abstract T getById(long id) throws SQLException;

    public abstract boolean update(T object) throws SQLException;

    public abstract boolean delete(T object) throws SQLException;
}
