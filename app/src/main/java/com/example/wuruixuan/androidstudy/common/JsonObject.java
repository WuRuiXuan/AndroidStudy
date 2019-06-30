package com.example.wuruixuan.androidstudy.common;

import java.util.ArrayList;

public class JsonObject {
    private String login;
    private ArrayList<User> users = new ArrayList<User>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "JsonObject{" +
                "login='" + login + '\'' +
                ", users=" + users +
                '}';
    }
}
