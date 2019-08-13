package com.example.santanderdesafio.login;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.santanderdesafio.R;

import java.util.Objects;

interface LoginActivityInputOutput {
    void inputLogin(LoginRequest loginRequest);
    void outputLogin(LoginResponse loginResponse);
}

public class LoginActivity extends AppCompatActivity implements LoginActivityInputOutput {

    LoginInteractorInput output;
    EditText edtUser;
    EditText edtPassoword;
    Button btnLogin;
    LoginResponse loginResponse;
    LoginRouter loginRouter;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        initComponents();

        LoginConfigurator.INSTANCE.configure(this);

        btnLogin.setOnClickListener(loginRouter);
    }

    private void initComponents() {
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

    @Override
    public void inputLogin(LoginRequest loginRequest) {
        output.fetchLogin(loginRequest);
    }

    @Override
    public void outputLogin(LoginResponse response) {
        loginResponse = response;
    }
}
