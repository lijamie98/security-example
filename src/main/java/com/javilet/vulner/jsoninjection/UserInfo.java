package com.javilet.vulner.jsoninjection;

import java.util.Arrays;

/**
 * Created by jamie on 6/26/18.
 */
public class UserInfo {
    private String username = "";
    private String password = "";
    private String role = "user";

    public UserInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
