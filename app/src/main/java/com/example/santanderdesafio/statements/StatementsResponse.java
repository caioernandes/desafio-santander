package com.example.santanderdesafio.statements;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class StatementsResponse implements Serializable {

    @SerializedName("statementList")
    private ArrayList<StatementsModel> statementList;

    public ArrayList<StatementsModel> getStatementList() {
        return statementList;
    }

    public void setStatementList(ArrayList<StatementsModel> statementList) {
        this.statementList = statementList;
    }
}
