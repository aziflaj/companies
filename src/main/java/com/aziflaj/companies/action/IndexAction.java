package com.aziflaj.companies.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/")
//@InterceptorRef("auth-interceptor")
public class IndexAction extends ActionSupport {

    @Action(value = "index",
            results = {@Result(name = SUCCESS, location = "/results/hello.jsp")})
    public String index() {
        System.out.println("Index");
        return SUCCESS;
    }


    @Action(value = "/other",
            results = {@Result(name = SUCCESS, location = "/results/hello.jsp")})
    public String other() {
        System.out.println("Other");
        return SUCCESS;
    }
}
