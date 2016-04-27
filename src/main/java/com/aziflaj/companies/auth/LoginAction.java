package com.aziflaj.companies.auth;

import com.aziflaj.companies.db.DbConnector;
import com.aziflaj.companies.db.model.Company;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.sql.SQLException;

public class LoginAction extends ActionSupport {
    private String email;
    private String password;

    @Override
    public String execute() throws SQLException {
        Company company = Company.getByEmail(DbConnector.getConnection(), email);
        if (company == null) {
            return "require-login";
        } else if (Auth.passwordCheck(password, company.getPassword())) {
            ServletActionContext.getRequest().getSession().setAttribute("login", true);
            ServletActionContext.getRequest().getSession().setAttribute("company", company);
            return SUCCESS;
        } else {
            // TODO: add flash message
            return "require-login";
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
