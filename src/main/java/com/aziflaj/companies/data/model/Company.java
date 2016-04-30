package com.aziflaj.companies.data.model;

public class Company {
    private long id; // Autoincrement
    private String nipt; // unique
    private String name;
    private String email; // unique
    private String password;
    private String address;

    public Company(long id, String nipt, String name, String address, String email, String password) {
        this.id = id;
        this.nipt = nipt;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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