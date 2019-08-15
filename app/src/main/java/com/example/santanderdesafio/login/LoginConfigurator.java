package com.example.santanderdesafio.login;

import java.lang.ref.WeakReference;

public enum LoginConfigurator {
    INSTANCE;

    public void configure(LoginActivity activity) {
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.output = new WeakReference<LoginActivityInputOutput>(activity);

        LoginInteractor loginInteractor = new LoginInteractor();
        loginInteractor.output = loginPresenter;

        if (activity.output == null) {
            activity.output = loginInteractor;
        }
    }
}
