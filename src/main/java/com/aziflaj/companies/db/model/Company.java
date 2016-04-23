package com.aziflaj.companies.db.model;

public class Company {
    private long id; // Autoincrement
    private String nipt; // unique
    private String name;
    private String address;

    public Company(long id, String nipt, String name, String address) {
        this.id = id;
        this.nipt = nipt;
        this.name = name;
        this.address = address;
    }

    public Company(String nipt, String name, String address) {
        this.id = 0;
        this.nipt = nipt;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getNipt() {
        return nipt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}