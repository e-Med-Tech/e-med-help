package com.example.e_med_help.dtos;

public class MockUsers {
    private int id;
    private String name;

    public MockUsers() {
    }

    public MockUsers(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
