package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.DbConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Base class for all Data Access Objects
 *
 * @param <T> The entity model that the DAO manages
 */
public abstract class BaseDao<T> {
    private Connection connection;

    public BaseDao() throws SQLException {
        connection = DbConnector.getConnection();
    }

    /**
     * Get the connection to the database
     *
     * @return The connection instance
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * This method returns a list of all the entities in the data store
     *
     * @return A List of all the entities
     * @throws SQLException
     */
    public abstract List<T> all() throws SQLException;

    /**
     * Gets a single entity from the data store
     *
     * @param id The ID of the entity
     * @return The entity with the given ID, or null if it is not found
     * @throws SQLException
     */
    public abstract T getById(long id) throws SQLException;

    /**
     * Inserts an entity in the data store
     *
     * @param object The object to insert in the data store
     * @return The object after being updated with the ID
     * @throws SQLException
     */
    public abstract T insert(T object) throws SQLException;

    /**
     * Update a given entity
     *
     * @param object The entity to update
     * @return true if the update is done correctly, otherwise false
     * @throws SQLException
     */
    public abstract boolean update(T object) throws SQLException;

    /**
     * Delete a given entity from the data store
     *
     * @param object The object entity to delete
     * @return true if the entity is deleted, otherwise false
     * @throws SQLException
     */
    public abstract boolean delete(T object) throws SQLException;

    // public abstract List<T> findBy(String column, Object value);
}
