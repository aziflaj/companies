package com.aziflaj.companies.action;

import com.aziflaj.companies.data.model.Role;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

public class CreateNewSectorAction extends ActionSupport {
    private String sectorName;
    private String fullName;
    private String ssn;
    private Date dob;
    private Role employeeRole;

    @Override
    public String execute() {
        System.out.println("Full name " + fullName);
        System.out.println("SSN " + ssn);
        System.out.println("DoB " + dob);
//        System.out.println("Role " + employeeRole.getName());
        return SUCCESS;
    }

//    @Override
//    public void validate() {
//        // TODO: validate
//    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEmployeeRole(Role employeeRole) {
        this.employeeRole = employeeRole;
    }
}
