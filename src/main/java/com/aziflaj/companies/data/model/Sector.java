package com.aziflaj.companies.data.model;

public class Sector {
    private long id; //autoincrement
    private String name;
    private Office office;
    private Department department;

    public Sector(long id, String name, Office office, Department department) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Department getDepartment() {
        return department;
    }

//
//    public int getManagerCount(DbConnector connector) throws SQLException {
//        String query = "SELECT SUM(IF(r.name = 'manager', 1, 0)) as managers, "
//                + "SUM(IF(r.name = 'employee', 1, 0)) as employees, "
//                + "s.name "
//                + "FROM sectors as s "
//                + "LEFT JOIN employees AS e ON s.id = e.sector_id "
//                + "LEFT JOIN roles AS r ON r.id = e.role_id "
//                + "WHERE s.id = ? "
//                + "GROUP BY s.name;";
//
//        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
//        stmt.setLong(1, id);
//        ResultSet rs = stmt.executeQuery();
//        rs.first();
//
//        return rs.getInt("managers");
//    }
//
//    public int getTotalEmployeesNumber(DbConnector connector) throws SQLException {
//        String query = "SELECT SUM(IF(r.name = 'manager', 1, 0)) as managers, "
//                + "SUM(IF(r.name = 'employee', 1, 0)) as employees, "
//                + "s.name "
//                + "FROM sectors as s "
//                + "LEFT JOIN employees AS e ON s.id = e.sector_id "
//                + "LEFT JOIN roles AS r ON r.id = e.role_id "
//                + "WHERE s.id = ? "
//                + "GROUP BY s.name;";
//
//        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
//        stmt.setLong(1, id);
//        ResultSet rs = stmt.executeQuery();
//        rs.first();
//
//        return rs.getInt("managers") + rs.getInt("employees");
//    }
}
