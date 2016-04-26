package com.aziflaj.companies;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Conversion()
public class IndexAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    private Date now = new Date(System.currentTimeMillis());

    @TypeConversion(converter = "com.aziflaj.companies.DateConverter")
    public Date getDateNow() {
        return now;
    }

    public String execute() throws Exception {
        session.put("name", null);
        now = new Date(System.currentTimeMillis());
        Random rnd = new Random();
        if (rnd.nextInt(100) < 50) {
            session.put("name", "Aldo");
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
