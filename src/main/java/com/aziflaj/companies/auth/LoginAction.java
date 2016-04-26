package com.aziflaj.companies.auth;

import com.aziflaj.companies.db.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

public class LoginAction extends ActionSupport implements StrutsStatics {
    private String email;
    private String password;

    @Override
    public String execute() {
        User user = new User(email, password);
        ServletActionContext.getRequest().getSession().setAttribute("user", user);
        return SUCCESS;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
