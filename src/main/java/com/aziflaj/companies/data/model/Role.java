package com.aziflaj.companies.data.model;

public class Role {
    private long id;
    private String name;
    private Salary salary;

    public Role(long id, String name, Salary salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }
}
