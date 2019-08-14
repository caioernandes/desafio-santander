package com.example.santanderdesafio.services;

import com.example.santanderdesafio.login.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("user") String user,
                              @Field("password") String password);
}
