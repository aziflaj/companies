package com.aziflaj.companies.action.employee;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;

public class UpdateEmployeeAction extends ActionSupport {
    private long employeeId;
    private String fullName;
    private String socialSecurityNumber;
    private String email;

    private long sectorId, roleId;

    @Override
    public String execute() throws SQLException {
        System.out.println(employeeId);
        System.out.println(fullName);
        System.out.println(socialSecurityNumber);
        System.out.println(email);

        System.out.println(sectorId);
        System.out.println(roleId);

//        System.out.println("asdf");
//        EmployeeDao employeeDao = new EmployeeDao();
//        Employee employee = employeeDao.getById(employeeId);
//        System.out.println("1");
//        employee.setFullName(fullName);
//        employee.setEmail(email);
//        employee.setSocialSecurityNumber(socialSecurityNumber);
//        employee.setRole((new RoleDao()).getById(roleId));
//
//        if (sectorId != -1) {
//            employee.setSector((new SectorDao()).getById(sectorId));
//        }

//        System.out.println("2");
//        employeeDao.update(employee);
//        System.out.println("Updated");

        return SUCCESS;
    }

    @Override
    public void validate() {
        System.out.println("hhghg");
    }

    public void setEmployeeId(long employeeId) {
        System.out.println("employee id: " + employeeId);
        this.employeeId = employeeId;
    }

    public void setFullName(String fullName) {
        System.out.println("full name: " + fullName);
        this.fullName = fullName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        System.out.println("ssn: " + socialSecurityNumber);

        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setEmail(String email) {
        System.out.println("email: " + email);

        this.email = email;
    }

    public void setSectorId(long sectorId) {
        System.out.println("sector id: " + sectorId);
        this.sectorId = sectorId;
    }

    public void setRoleId(long roleId) {
        System.out.println("role id: " + roleId);
        this.roleId = roleId;
    }
}
