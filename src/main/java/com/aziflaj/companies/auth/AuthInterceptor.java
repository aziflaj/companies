package com.aziflaj.companies.auth;

import com.aziflaj.companies.Utils;
import com.aziflaj.companies.data.dao.CompanyDao;
import com.aziflaj.companies.data.model.Company;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
        Object loggedIn = session.getAttribute("login");
        if (loggedIn != null && (boolean) loggedIn) {
            LOGGER.debug("INVOKE");
            return actionInvocation.invoke();
        }

        Cookie seriesIdentifier = Utils.getCookieByName(cookies, "series_identifier");

        if (seriesIdentifier != null) {
            CompanyDao dao = new CompanyDao();
            String storedToken = dao.getRememberTokenById(
                    Long.valueOf(seriesIdentifier.getValue()));

            Cookie rememberToken = Utils.getCookieByName(cookies, "remember_token");
            if (rememberToken != null && Auth.passwordCheck(rememberToken.getValue(), storedToken)) {
                System.out.println("YYEEEEAAAAHHHH!");
                Company company = dao.getByToken(storedToken);
                System.out.println(company.getName());
                session.setAttribute("login", true);
                session.setAttribute("company", company);
                return actionInvocation.invoke();
            } else {
                System.out.println("aldo e ke dhi");
            }
        }
        return "require-login";
    }
}
