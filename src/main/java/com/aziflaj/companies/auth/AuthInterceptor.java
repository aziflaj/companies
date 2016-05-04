package com.aziflaj.companies.auth;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends AbstractInterceptor implements StrutsStatics {
    private static final Logger LOGGER = LogManager.getLogger(AuthInterceptor.class);

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        final ActionContext context = actionInvocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        LOGGER.debug("Intercepting");

        for (Cookie c : cookies) {
            if (c.getName().equals("series_identifier")) {
                System.out.println("series_identifier: " + c.getValue());
            } else if (c.getName().equals("remember_token")) {
                System.out.println("remember_token: " + c.getValue());
            }
        }

        Object loggedIn = session.getAttribute("login");
        if (loggedIn == null) {
            LOGGER.debug("REQUIRE LOGIN");
            return "require-login";
        } else if ((boolean) loggedIn) {
            LOGGER.debug("INVOKE");
            return actionInvocation.invoke();
        } else {
            // but why?
            return "require-login";
        }
    }
}
