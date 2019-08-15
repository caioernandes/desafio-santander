package com.example.santanderdesafio.statements;

import android.os.Bundle;
import com.example.santanderdesafio.BaseActivity;
import com.example.santanderdesafio.R;

import java.util.Objects;

public class StatementsActivity extends BaseActivity {

    public static String TAG = StatementsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releases);

        initComponents();
    }

    private void initComponents() {

        Objects.requireNonNull(getSupportActionBar()).hide();

        addFragment(R.id.frame_container,
                new StatementsListFragment(),
                StatementsListFragment.FRAGMENT_TAG);
    }
}
