package com.aziflaj.companies;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DemoInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Before action");
        String result = actionInvocation.invoke();
        System.out.println("After action");
        return result;
    }
}
