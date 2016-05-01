package com.aziflaj.companies.data.dao;

import com.aziflaj.companies.data.model.Department;
import com.aziflaj.companies.data.model.Sector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SectorDao extends BaseDao<Sector> {
    private DepartmentDao departmentDao;
    private OfficeDao officeDao;

    public SectorDao() throws SQLException {
        super();
        departmentDao = new DepartmentDao();
        officeDao = new OfficeDao();
    }

    @Override
    public List<Sector> all() throws SQLException {
        List<Sector> sectors = new ArrayList<>();
        String query = "SELECT id, name, office_id, department_id FROM sectors;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            sectors.add(new Sector(rs.getLong("id"),
                    rs.getString("name"),
                    officeDao.getById(rs.getLong("office_id")),
                    departmentDao.getById(rs.getLong("department_id"))));
        }
        return sectors;
    }

    @Override
    public Sector getById(long id) throws SQLException {
        String query = "SELECT name, office_id, department_id FROM sectors WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.first()) {
            return new Sector(id,
                    rs.getString("name"),
                    officeDao.getById(rs.getLong("office_id")),
                    departmentDao.getById(rs.getLong("company_id")));
        } else {
            return null;
        }
    }

    @Override
    public Sector insert(Sector sector) throws SQLException {
        String query = "INSERT INTO sectors (name, office_id, department_id) " +
                "VALUES (?, ?, ?);";
        PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, sector.getName());
        statement.setLong(2, sector.getOffice().getId());
        statement.setLong(3, sector.getDepartment().getId());

        if (statement.executeUpdate() == 1) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.first()) {
                long id = rs.getLong(1);
                sector.setId(id);
                return sector;
            }
        }
        return null;
    }

    @Override
    public boolean update(Sector sector) throws SQLException {
        String query = "UPDATE sectors " +
                "SET name =  ?, office_id = ?, department_id = ? " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, sector.getName());
        statement.setLong(2, sector.getOffice().getId());
        statement.setLong(3, sector.getDepartment().getId());
        statement.setLong(4, sector.getId());

        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean delete(Sector sector) throws SQLException {
        String query = "DELETE FROM sectors " +
                "WHERE id = ?;";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, sector.getId());

        return statement.executeUpdate() == 1;
    }

    public List<Sector> getByDepartment(Department department) throws SQLException {
        List<Sector> sectors = new ArrayList<>();

        String query = "SELECT id, name, office_id " +
                "FROM sectors " +
                "WHERE department_id = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setLong(1, department.getId());
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            sectors.add(new Sector(rs.getLong("id"),
                    rs.getString("name"),
                    officeDao.getById(rs.getLong("office_id")),
                    department));
        }
        return sectors;
    }
}
