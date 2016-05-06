package com.aziflaj.companies.action.employee;

import com.aziflaj.companies.Validator;
import com.aziflaj.companies.data.dao.EmployeeDao;
import com.aziflaj.companies.data.dao.RoleDao;
import com.aziflaj.companies.data.dao.SectorDao;
import com.aziflaj.companies.data.model.Employee;
import com.aziflaj.companies.data.model.Role;
import com.aziflaj.companies.data.model.Sector;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.Date;

public class CreateEmployeeAction extends ActionSupport {
    private String fullName;
    private String ssn;
    private String email;
    private Date dob;
    private long employeeId;
    private long sectorId;

    @Override
    public String execute() {
        try {
            RoleDao roleDao = new RoleDao();
            Role employeeRole = roleDao.getById(employeeId);

            SectorDao sectorDao = new SectorDao();
            Sector sector = sectorDao.getById(sectorId);

            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = new Employee(-1, fullName, ssn, email, new Date(), employeeRole, sector);

            employee = employeeDao.insert(employee);
            System.out.println("inserted w/ id " + employee.getId());
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (fullName == null || StringUtils.isBlank(fullName)) {
            addFieldError("fullName", "Full name is required");
        }

        if (!Validator.validName(fullName)) {
            addFieldError("fullName", "Full name is invalid");
        }

        if (ssn == null || StringUtils.isBlank(ssn)) {
            addFieldError("ssn", "The SSN is required");
        }

        if (!Validator.validSsn(ssn)) {
            addFieldError("ssn", "The SSN was invalid");
        }

        if (email == null || StringUtils.isBlank(email)) {
            addFieldError("email", "The email is required");
        }

        if (!Validator.validEmail(email)) {
            addFieldError("email", "The email was invalid");
        }

        if (employeeId < 0) {
            addFieldError("employeeId", "The role selected was invalid");
        }

        if (sectorId < 0) {
            addFieldError("sectorId", "The sector selected was invalid");
        }
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

//    public void setDob(Date dob) {
//        this.dob = dob;
//    }

    public void setEmployeeId(long employeeId) {
        System.out.println("EMPLOYEE ROLE ID: " + employeeId);
        this.employeeId = employeeId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSectorId(Long sectorId) {
        System.out.println("sector ROLE ID: " + sectorId);
        this.sectorId = sectorId;
    }
}
