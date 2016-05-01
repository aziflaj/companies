package com.aziflaj.companies.data.model;

public class Role {
    private long id;
    private String name;
    private Salary salary;

    public Role(long id, String name, Salary salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

//	@Override
//	public PreparedStatement prepareInsertStatement(DbConnector connector) throws SQLException {
//		String insertQuery = "INSERT INTO companies_db.roles "
//				+ "(name, salary_id) "
//				+ "VALUES (?, ?);";
//
//		PreparedStatement stmt = connector.getConnection().prepareStatement(insertQuery);
//		stmt.setString(1, name);
//		stmt.setLong(2, salary.getId());
//
//		return stmt;
//	}
//
//	public static Role getById(DbConnector connector, long id) throws SQLException {
//		String selectQuery = "SELECT name, salary_id "
//				+ "FROM companies_db.roles "
//				+ "WHERE id = ?;";
//
//		PreparedStatement stmt = connector.getConnection().prepareStatement(selectQuery);
//		stmt.setLong(1, id);
//
//		ResultSet rs = stmt.executeQuery();
//		if (rs.first()) {
//			System.out.println("role: " + rs.getString("name"));
//			return new Role(id,
//					rs.getString("name"),
//					Salary.getById(connector, rs.getLong("salary_id")));
//		} else {
//			return null;
//		}
//	}
}
