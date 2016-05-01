package com.aziflaj.companies.data.model;

public class Office {
    private long id; //autoincrement
    private int tables;
    private int personalComputers;
    private int laptops;
    private int chairs;
    private int windows;
    private int books;
    private int pencils;
    private int pens;
    //etj

    public Office(long id, int tables, int personalComputers, int laptops, int chairs, int windows, int books,
                  int pencils, int pens) {
        this.id = id;
        this.tables = tables;
        this.personalComputers = personalComputers;
        this.laptops = laptops;
        this.chairs = chairs;
        this.windows = windows;
        this.books = books;
        this.pencils = pencils;
        this.pens = pens;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }

    public int getPersonalComputers() {
        return personalComputers;
    }

    public void setPersonalComputers(int personalComputers) {
        this.personalComputers = personalComputers;
    }

    public int getLaptops() {
        return laptops;
    }

    public void setLaptops(int laptops) {
        this.laptops = laptops;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getBooks() {
        return books;
    }

    public void setBooks(int books) {
        this.books = books;
    }

    public int getPencils() {
        return pencils;
    }

    public void setPencils(int pencils) {
        this.pencils = pencils;
    }

    public int getPens() {
        return pens;
    }

    public void setPens(int pens) {
        this.pens = pens;
    }
}
