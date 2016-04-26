package com.aziflaj.companies.auth;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

public class LogoutAction extends ActionSupport implements StrutsStatics {

    @Override
    public String execute() {
        ServletActionContext.getRequest().getSession().setAttribute("user", null);
        return SUCCESS;
    }
}
