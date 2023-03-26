package com.data;

import java.io.Serializable;

public class Client implements Serializable {
    String username;
    String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


