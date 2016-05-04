package com.aziflaj.companies;

import javax.servlet.http.Cookie;

public class Utils {
    public static Cookie getCookieByName(Cookie[] cookies, String name) {
        for (Cookie c : cookies) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
}
