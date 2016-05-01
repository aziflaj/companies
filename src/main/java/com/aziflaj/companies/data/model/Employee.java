package com.aziflaj.companies.data.model;

import java.util.Date;

public class Employee {
    private long id;
    private String fullName;
    private String socialSecurityNumber;
    private String email;
    private Date dateOfBirth;

    private Role role;
    private Sector sector;

    public Employee(String fullName, String ssn, String email, Role role, Sector sector) {
        this.id = 0;
        this.fullName = fullName;
        this.socialSecurityNumber = ssn;
        this.email = email;
        this.dateOfBirth = new Date();
        this.role = role;
        this.sector = sector;
    }

    public Employee(long id, String fullName, String ssn, String email,
                    Date dob, Role role, Sector sector) {
        this.id = id;
        this.fullName = fullName;
        this.socialSecurityNumber = ssn;
        this.email = email;
        this.dateOfBirth = dob;
        this.role = role;
        this.sector = sector;
    }

    public Employee(long id, String fullName, String ssn, String email, Date dob) {
        this.id = id;
        this.fullName = fullName;
        this.socialSecurityNumber = ssn;
        this.email = email;
        this.dateOfBirth = dob;

        this.role = null;
        this.sector = null;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

//	@Override
//	public PreparedStatement prepareInsertStatement(DbConnector connector) throws SQLException {
//		String insertQuery = "INSERT INTO companies_db.employees "
//				+ "(full_name, ssn, email, dob, role_id, sector_id) "
//				+ "VALUES (?, ?, ?, ?, ?, ?);";
//
//		PreparedStatement stmt = connector.getConnection().prepareStatement(insertQuery);
//		stmt.setString(1, fullName);
//		stmt.setString(2, socialSecurityNumber);
//		stmt.setString(3, email);
//		stmt.setDate(4, new java.sql.Date(dateOfBirth.getTime()));
//		System.out.println("Role id: " + role.getId());
//		stmt.setLong(5, role.getId());
//		stmt.setLong(6, sector.getId());
//
//		return stmt;
//	}
//
//	public static Employee getById(DbConnector connector, long id) throws SQLException {
//		String selectQuery = "SELECT full_name, ssn, email, dob, role_id, sector_id "
//				+ "FROM companies_db.employees "
//				+ "WHERE id = ?;";
//
//		PreparedStatement stmt = connector.getConnection().prepareStatement(selectQuery);
//		stmt.setLong(1, id);
//
//		ResultSet rs = stmt.executeQuery();
//		if (rs.first()) {
//			return new Employee(id,
//					rs.getString("full_name"),
//					rs.getString("ssn"),
//					rs.getString("email"),
//					rs.getDate("dob"),
//					Role.getById(connector, rs.getLong("role_id")),
//					Sector.getById(connector, rs.getLong("sector_id")));
//		} else {
//			return null;
//		}
//	}
}
