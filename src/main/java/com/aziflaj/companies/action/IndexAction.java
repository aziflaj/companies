package com.aziflaj.companies.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;

//@ResultPath("/")
//@Namespace(value = "/")
//@Action(value = "/")
//@Result(name = "success", location = "/WEB-INF/jsp/index.jsp")
@Result(name = "success", location = "/results/hello.jsp")
//@InterceptorRef("auth-interceptor")
public class IndexAction extends ActionSupport {

//    @Action(value = "/index")
//    public String execute() {
//        System.out.println("lalalong");
//        return SUCCESS;
//    }
}
