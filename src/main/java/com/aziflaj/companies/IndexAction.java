package com.aziflaj.companies;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

import java.util.Date;

@Conversion()
public class IndexAction extends ActionSupport {

    private Date now = new Date(System.currentTimeMillis());

    @TypeConversion(converter = "com.aziflaj.companies.DateConverter")
    public Date getDateNow() {
        return now;
    }

    public String execute() throws Exception {
        now = new Date(System.currentTimeMillis());
        return SUCCESS;
    }
}
