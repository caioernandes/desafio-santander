package com.example.santanderdesafio.statements;

import java.lang.ref.WeakReference;

public enum StatementsConfigurator {
    INSTANCE;

    public void configure(StatementsListFragment fragment) {
        StatementsPresenter presenter = new StatementsPresenter();
        presenter.output = new WeakReference<>(fragment);

        StatementsInteractor interactor = new StatementsInteractor();
        interactor.output = presenter;

        if (fragment.output == null) {
            fragment.output = interactor;
        }
    }
}
