package com.aziflaj.companies.data.model;

public class Salary {
    private long id;
    private double value;

    public Salary(long id, double value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public double getSalary() {
        return value;
    }

    public void setSalary(double salary) {
        value = salary;
    }

//	@Override
//	public PreparedStatement prepareInsertStatement(DbConnector connector) throws SQLException {
//		String insertQuery = "INSERT INTO companies_db.salaries "
//				+ "(value) "
//				+ "VALUES (?);";
//
//		PreparedStatement stmt = connector.getConnection().prepareStatement(insertQuery);
//		stmt.setDouble(1, value);
//
//		return stmt;
//	}
//
//	public static Salary getById(DbConnector connector, long id) throws SQLException {
//		String selectQuery = "SELECT value "
//				+ "FROM companies_db.salaries "
//				+ "WHERE id = ?;";
//
//		PreparedStatement stmt = connector.getConnection().prepareStatement(selectQuery);
//		stmt.setLong(1, id);
//
//		ResultSet rs = stmt.executeQuery();
//		if (rs.first()) {
//			return new Salary(id, rs.getDouble("value"));
//		} else {
//			return null;
//		}
//	}
}
