package com.example.santanderdesafio.login;

import android.util.Log;
import com.example.santanderdesafio.services.APIClient;
import com.example.santanderdesafio.services.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

interface LoginInteractorInput {
    void fetchLogin(LoginRequest loginRequest);
}

public class LoginInteractor implements LoginInteractorInput {

    LoginPresenterInput output;
    private static String TAG = LoginInteractor.class.getSimpleName();

    @Override
    public void fetchLogin(LoginRequest loginRequest) {

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<LoginResponse> call = apiInterface.login(loginRequest.user, loginRequest.password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    output.presentLoginMetaData(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

        //LoginResponse loginResponse = call.execute().body();
    }
}
