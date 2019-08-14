package com.example.santanderdesafio.statements;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StatementModel implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("desc")
    private String description;

    @SerializedName("date")
    private String date;

    @SerializedName("value")
    private float value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public StatementModel() {

    }

    public StatementModel(String title, String description, String date, float value) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.value = value;
    }
}
