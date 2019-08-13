package com.example.santanderdesafio.login;

import java.lang.ref.WeakReference;

interface LoginPresenterInput {
    void presentLoginMetaData(LoginResponse loginResponse);
}

public class LoginPresenter implements LoginPresenterInput {

    public static String TAG = LoginPresenter.class.getSimpleName();
    public WeakReference<LoginActivityInputOutput> output;

    @Override
    public void presentLoginMetaData(LoginResponse loginResponse) {
        if (loginResponse != null) {
            output.get().outputLogin(loginResponse);
        }
    }
}
