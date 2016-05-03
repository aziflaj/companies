package com.aziflaj.companies.data.model;

public class Salary {
    private long id;
    private double value;

    public Salary(long id, double value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return value;
    }

    public void setSalary(double salary) {
        value = salary;
    }
}
