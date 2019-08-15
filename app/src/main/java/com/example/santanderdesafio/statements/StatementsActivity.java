package com.example.santanderdesafio.statements;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.santanderdesafio.BaseActivity;
import com.example.santanderdesafio.R;
import com.example.santanderdesafio.helpers.KeyStore;
import com.example.santanderdesafio.login.LoginResponse;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class StatementsActivity extends BaseActivity {

    public static String TAG = StatementsActivity.class.getSimpleName();
    private TextView mtxtNameAccount;
    private TextView mTxtAgencyAccount;
    private TextView mTxtBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releases);

        hideActionBar();

        initComponents();
        populateInfoUser();
    }

    private void initComponents() {
        mtxtNameAccount = findViewById(R.id.txtNameAccount);
        mTxtAgencyAccount = findViewById(R.id.txtAgencyAccount);
        mTxtBalance = findViewById(R.id.txtBalance);

        addFragment(R.id.frame_container,
                new StatementsListFragment(),
                StatementsListFragment.FRAGMENT_TAG);
    }

    private void populateInfoUser() {
        Intent i = Objects.requireNonNull(getIntent());
        LoginResponse loginResponse = (LoginResponse) i.getSerializableExtra("login_response");

        String user = i.getStringExtra("user");
        KeyStore.getInstance(this).put("user", user);

        String pass = i.getStringExtra("password");
        KeyStore.getInstance(this).savePassword(pass);

        if (loginResponse != null && loginResponse.getUserAccount() != null) {
            mtxtNameAccount.setText(loginResponse.getUserAccount().getName());
            mTxtAgencyAccount.setText(loginResponse.getUserAccount().getBankAccount() +
                    " / " +
                    loginResponse.getUserAccount().getAgency());

            String balance = convertToReal(loginResponse.getUserAccount().getBalance());
            mTxtBalance.setText(balance);
        }
    }

    private String convertToReal(float number) {
        Locale ptBr = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(ptBr).format(number);
    }
}
