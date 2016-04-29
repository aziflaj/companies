package com.aziflaj.companies.data.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
    List<T> all() throws SQLException;

    T getById(long id) throws SQLException;

    boolean update(T object) throws SQLException;

    boolean delete(T object) throws SQLException;
}
