package com.aziflaj.companies;

import com.aziflaj.companies.db.DbConnector;
import com.aziflaj.companies.db.model.Company;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompaniesAction extends ActionSupport {
    private List<Company> companies;

    public String execute() {
        String companiesSql = "SELECT id, nipt, name, address FROM companies";
        try {
            Connection connection = DbConnector.getConnection();
            if (connection == null) {
                return ERROR;
            }

            PreparedStatement statement = connection.prepareStatement(companiesSql);
            ResultSet rs = statement.executeQuery();
            companies = new ArrayList<>();
            while (rs.next()) {
                Company c = new Company(rs.getLong("id"),
                        rs.getString("nipt"),
                        rs.getString("name"),
                        rs.getString("address"));
                companies.add(c);
            }
            return SUCCESS;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ERROR;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
