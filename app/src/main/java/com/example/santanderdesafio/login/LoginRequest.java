package com.example.santanderdesafio.login;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginRequest implements Serializable {

    @SerializedName("user") String user;
    @SerializedName("password") String password;

    public LoginRequest() {

    }

    public LoginRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }
}