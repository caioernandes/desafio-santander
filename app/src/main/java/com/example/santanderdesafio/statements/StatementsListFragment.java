package com.example.santanderdesafio.statements;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.santanderdesafio.BuildConfig;
import com.example.santanderdesafio.R;
import com.example.santanderdesafio.adapters.StatementsAdapter;
import com.example.santanderdesafio.login.LoginResponse;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

interface StatementsFragmentInput {
    void displayStatementsMetaData(ArrayList<StatementsModel> statementsModelArrayList);
}

public class StatementsListFragment extends Fragment implements StatementsFragmentInput {

    public static final String FRAGMENT_TAG =
            BuildConfig.APPLICATION_ID + ".STATEMENTS_LIST_FRAGMENT";

    public ArrayList<StatementsModel> statementsList;
    private RecyclerView rv;
    StatementsInteractorInput output;

    public StatementsListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatementsConfigurator.INSTANCE.configure(this);
        fetchMetaData();
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statements_list, container, false);
        initComponents(view);

        return view;
    }

    private void initComponents(View view) {
        rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
    }

    @Override
    public void displayStatementsMetaData(ArrayList<StatementsModel> statementsModelArrayList) {
        StatementsAdapter adapter = new StatementsAdapter(statementsModelArrayList);
        rv.setAdapter(adapter);
    }

    private void fetchMetaData() {
        StatementsRequest request = new StatementsRequest();
        Intent i = Objects.requireNonNull(getActivity()).getIntent();
        LoginResponse loginResponse = (LoginResponse) i.getSerializableExtra("login_response");
        request.userId = loginResponse.getUserAccount().getUserId();
        output.fetchStatementsMetaData(request);
    }
}
