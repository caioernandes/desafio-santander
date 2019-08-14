package com.example.santanderdesafio.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.santanderdesafio.statements.StatementsActivity;

import java.lang.ref.WeakReference;

interface LoginRouterInput {
    Intent determineNextScreen();
    void passDataToStatementScreen();
}

public class LoginRouter implements LoginRouterInput, View.OnClickListener {

    public static String TAG = LoginRouter.class.getSimpleName();
    public WeakReference<LoginActivity> activity;
    private Intent intent;

    @Override
    public void onClick(View v) {

        if (activity.get().validationComponents()) {

            activity.get().changeVisibilityProgress(View.VISIBLE);

            String user = activity.get().edtUser.getText().toString();
            String password = activity.get().edtPassoword.getText().toString();

            if (!user.equals("") && !password.equals("")) {
                activity.get().inputLogin(new LoginRequest(user, password));

                intent = determineNextScreen();
                passDataToStatementScreen();
                activity.get().changeVisibilityProgress(View.INVISIBLE);

                activity.get().startActivity(intent);
            }
        }
    }

    @Override
    public Intent determineNextScreen() {
        return new Intent(activity.get(), StatementsActivity.class);
    }

    @Override
    public void passDataToStatementScreen() {
        LoginResponse loginResponse = activity.get().loginResponse;

        Bundle bundle = new Bundle();
        bundle.putSerializable("login_response", loginResponse);

        intent.putExtras(bundle);
    }
}
