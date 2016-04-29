package com.aziflaj.companies.auth;

import com.aziflaj.companies.Validator;
import com.aziflaj.companies.data.DbConnector;
import com.aziflaj.companies.data.model.Company;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public void validate() {
        if (email == null || StringUtils.isBlank(email)) {
            addFieldError("email", "Email is required");
        }

        if (!Validator.validEmail(email)) {
            addFieldError("email", "Use a valid email address");
        }

        if (password == null || StringUtils.isBlank(password)) {
            addFieldError("password", "Password is required");
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
