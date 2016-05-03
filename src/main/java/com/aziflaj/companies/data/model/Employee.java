package com.aziflaj.companies.data.model;

import java.util.Date;

public class Employee {
    private long id;
    private String fullName;
    private String socialSecurityNumber;
    private String email;
    private Date dateOfBirth;

    private Role role;
    private Sector sector;

    public Employee(long id, String fullName, String ssn, String email, Date dob, Role role, Sector sector) {
        this.id = id;
        this.fullName = fullName;
        this.socialSecurityNumber = ssn;
        this.email = email;
        this.dateOfBirth = dob;
        this.role = role;
        this.sector = sector;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
