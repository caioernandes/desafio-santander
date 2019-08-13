package com.example.santanderdesafio.login;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    @SerializedName("userAccount")
    private UserAccount userAccount;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public LoginResponse() {

    }

    public LoginResponse(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}