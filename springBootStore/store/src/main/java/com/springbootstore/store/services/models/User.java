package com.springbootstore.store.services.models;

public class User {

    public final int id;
    public final String name;
    public final String email;
    public final String password;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
