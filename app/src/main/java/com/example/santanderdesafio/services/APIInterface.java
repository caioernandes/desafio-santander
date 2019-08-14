package com.example.santanderdesafio.services;

import com.example.santanderdesafio.login.LoginResponse;
import com.example.santanderdesafio.statements.StatementsResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface APIInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("user") String user,
                              @Field("password") String password);

    @GET("statements/{userId}")
    Call<StatementsResponse> statements(@Path("userId") int userId);
}
