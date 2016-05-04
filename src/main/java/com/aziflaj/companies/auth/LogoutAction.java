package com.aziflaj.companies.auth;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends ActionSupport {

    @Override
    public String execute() {
        HttpServletResponse response = ServletActionContext.getResponse();
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("series_identifier") || c.getName().equals("remember_token")) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        ServletActionContext.getRequest().getSession().invalidate();
        return SUCCESS;
    }
}
