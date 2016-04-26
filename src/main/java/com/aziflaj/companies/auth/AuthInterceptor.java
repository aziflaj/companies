package com.aziflaj.companies.auth;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends AbstractInterceptor implements StrutsStatics {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        final ActionContext context = actionInvocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            return actionInvocation.invoke();
        }
    }
}
