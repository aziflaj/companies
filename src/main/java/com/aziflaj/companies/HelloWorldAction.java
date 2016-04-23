package com.aziflaj.companies;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import java.util.Date;

@Conversion()
public class HelloWorldAction extends ActionSupport {

    private Date now;
    private String name;

    public Date getDateNow() {
        return now;
    }

    @TypeConversion(converter = "com.aziflaj.companies.DateConverter")
    @RequiredFieldValidator(message = "Please enter the date")
    public void setDateNow(Date now) {
        this.now = now;
    }

    public String getName() {
        return this.name;
    }

    @RequiredStringValidator(message = "Please enter a name", trim = true)
    public void setName(String name) {
        this.name = name;
    }

    public String execute() throws Exception {
        System.out.println("Acting...");
        return SUCCESS;
    }
}
