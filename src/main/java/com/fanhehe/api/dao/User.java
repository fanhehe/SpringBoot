package com.fanhehe.api.dao;

import org.springframework.stereotype.Repository;

@Repository
public class User {

    private long id;
    private String userName = "";
    private transient String password = "";

    public User () {}


    public User (long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    @Override
    public String toString () {
        return "User [id = " + id + " userName = " + userName + " password = " + password + "]";
    }
}