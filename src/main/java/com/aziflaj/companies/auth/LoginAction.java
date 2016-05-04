package com.aziflaj.companies.auth;

import com.aziflaj.companies.Validator;
import com.aziflaj.companies.data.dao.CompanyDao;
import com.aziflaj.companies.data.model.Company;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import java.sql.SQLException;

public class LoginAction extends ActionSupport {
    private String email;
    private String password;
    private boolean remember;

    @Override
    public String execute() throws SQLException {
        CompanyDao companyDao = new CompanyDao();

        Company company = companyDao.getByEmail(email);
        if (company == null) {
            return "require-login";
        } else if (Auth.passwordCheck(password, company.getPassword())) {
            ServletActionContext.getRequest().getSession().setAttribute("login", true);
            ServletActionContext.getRequest().getSession().setAttribute("company", company);

            if (remember) {
                // TODO: create cookie
                Cookie seriesIdentifier = new Cookie("series_identifier", "the identifier");
                Cookie rememberToken = new Cookie("remember_token", "the token");
                ServletActionContext.getResponse().addCookie(seriesIdentifier);
                ServletActionContext.getResponse().addCookie(rememberToken);
            }
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

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}
