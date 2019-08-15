package com.example.santanderdesafio.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.example.santanderdesafio.BaseActivity;
import com.example.santanderdesafio.R;
import com.example.santanderdesafio.helpers.KeyStore;
import com.example.santanderdesafio.statements.StatementsActivity;

import java.util.Objects;

interface LoginActivityInputOutput {
    void inputLogin(LoginRequest loginRequest);

    void outputLogin(LoginResponse loginResponse);
}

public class LoginActivity extends BaseActivity implements LoginActivityInputOutput, View.OnClickListener {

    public LoginInteractorInput output;
    private EditText edtUser;
    private EditText edtPassoword;
    private Button btnLogin;
    private ProgressBar progressBar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        hideActionBar();

        initComponents();

        LoginConfigurator.INSTANCE.configure(this);

        verifyUserLast();

        btnLogin.setOnClickListener(this);
    }

    private void verifyUserLast() {
        String user = KeyStore.getInstance(this).get("user");
        String pass = KeyStore.getInstance(this).getPassword();

        if (user != null && !Objects.requireNonNull(user).equals("") && !Objects.requireNonNull(pass).equals("")) {

            changeVisibilityProgress(View.VISIBLE);

            edtUser.setText(user);
            edtUser.setClickable(false);
            edtPassoword.setText(getString(R.string.password_fake));
            edtPassoword.setClickable(false);

            LoginRequest loginRequest = new LoginRequest(user, pass);
            inputLogin(loginRequest);
        } else {
            changeVisibilityProgress(View.INVISIBLE);
        }
    }

    private void initComponents() {

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        edtUser = findViewById(R.id.edtUser);
        edtPassoword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.loading_progress_xml);
    }

    public boolean validationComponents() {
        if (edtUser.getText() != null || edtPassoword.getText() != null) {
            if (edtUser.getText() == null) {
                return false;
            } else if (edtUser.getText().length() > 1 && edtUser.getText().length() < 4) {
                return false;
            }
            if (edtPassoword.getText() == null) {
                return false;
            } else return edtPassoword.getText().length() <= 1 || edtPassoword.getText().length() >= 4;
        } else {
            return false;
        }
    }

    public void inputLogin(LoginRequest loginRequest) {
        output.fetchLogin(loginRequest);
    }

    public void outputLogin(LoginResponse response) {
        intent = determineNextScreen();
        passDataToStatementScreen(response);

        changeVisibilityProgress(View.INVISIBLE);

        finish();
        startActivity(intent);
    }

    public void changeVisibilityProgress(int visibility) {
        progressBar.setVisibility(visibility);
    }

    public Intent determineNextScreen() {
        return new Intent(this, StatementsActivity.class);
    }

    public void passDataToStatementScreen(LoginResponse loginResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("login_response", loginResponse);

        String user = edtUser.getText().toString();
        bundle.putString("user", user);

        String pass = edtPassoword.getText().toString();
        bundle.putString("password", pass);

        intent.putExtras(bundle);
    }

    @Override
    public void onClick(View view) {
        changeVisibilityProgress(View.VISIBLE);

        if (validationComponents()) {
            String user = edtUser.getText().toString();
            String password = edtPassoword.getText().toString();

            if (!user.equals("") && !password.equals("")) {
                inputLogin(new LoginRequest(user, password));
            }
        }
    }
}
