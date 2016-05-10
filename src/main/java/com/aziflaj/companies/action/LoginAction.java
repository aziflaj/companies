package com.aziflaj.companies.action;

import com.aziflaj.companies.Validator;
import com.aziflaj.companies.auth.Auth;
import com.aziflaj.companies.data.dao.CompanyDao;
import com.aziflaj.companies.data.model.Company;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.servlet.http.Cookie;
import java.sql.SQLException;

@Namespace("/")
@InterceptorRef("defaultStack")
public class LoginAction extends ActionSupport {
    private String email;
    private String password;
    private boolean remember;

    @Action(value = "login-form",
            results = {@Result(name = {SUCCESS, INPUT}, location = "/login.jsp")})
    public String loginForm() {
        return SUCCESS;
    }

    @Action(value = "login", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {"actionName", "index"}),
            @Result(name = INPUT, location = "/login.jsp")
    })
    public String doLogin() throws SQLException {
        if (!valid()) {
            return INPUT;
        }

        CompanyDao companyDao = new CompanyDao();

        Company company = companyDao.getByEmail(email);
        if (company == null) {
            return "require-login";
        } else if (Auth.passwordCheck(password, company.getPassword())) {
            ServletActionContext.getRequest().getSession().setAttribute("login", true);
            ServletActionContext.getRequest().getSession().setAttribute("company", company);
            System.out.println("Logged in as " + company.getName());

            if (remember) {
                String token = Auth.generateRememberToken();

                Cookie seriesIdentifier = new Cookie("series_identifier",
                        String.valueOf(company.getId()));
                seriesIdentifier.setMaxAge(60 * 60 * 24 * 365 * 20);
                // seriesIdentifier.setSecure(true); // TODO: uncomment after using HTTPS
                ServletActionContext.getResponse().addCookie(seriesIdentifier);

                Cookie rememberToken = new Cookie("remember_token", token);
                rememberToken.setMaxAge(60 * 60 * 24 * 365 * 20); // expire after 20 years
                ServletActionContext.getResponse().addCookie(rememberToken);

                System.out.println("Cookie token: " + token);
                // store the hashed token in the DB
                token = Auth.passwordHash(token);
                System.out.println("Stored token: " + token);
                companyDao.setRememberToken(company, token);
            }

            return SUCCESS;
        } else {
            // TODO: add flash message
            return "require-login";
        }
    }

    private boolean valid() {
        if (email == null || StringUtils.isBlank(email)) {
            addFieldError("email", "Email is required");
            return false;
        }

        if (!Validator.validEmail(email)) {
            addFieldError("email", "Use a valid email address");
            return false;
        }

        if (password == null || StringUtils.isBlank(password)) {
            addFieldError("password", "Password is required");
            return false;
        }

        return true;
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
