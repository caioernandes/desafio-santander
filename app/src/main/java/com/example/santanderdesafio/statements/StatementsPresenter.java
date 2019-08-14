package com.example.santanderdesafio.statements;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

interface StatementsPresenterInput {
    void presentStatementsMetaData(StatementsResponse statementsResponse);
}

public class StatementsPresenter implements StatementsPresenterInput {

    public static String TAG = StatementsPresenter.class.getSimpleName();
    public WeakReference<StatementsListFragment> output;

    @Override
    public void presentStatementsMetaData(StatementsResponse statementsResponse) {
        if (statementsResponse != null && statementsResponse.getStatementList() != null) {
            ArrayList<StatementsModel> statementsModelArrayList = statementsResponse.getStatementList();
            output.get().displayStatementsMetaData(statementsModelArrayList);
        }
    }
}
