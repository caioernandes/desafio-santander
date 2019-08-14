package com.example.santanderdesafio.login;

import android.util.Log;
import com.example.santanderdesafio.services.APIClient;
import com.example.santanderdesafio.services.APIInterface;
import retrofit2.Call;

import java.io.IOException;

interface LoginInteractorInput {
    void fetchLogin(LoginRequest loginRequest);
}

public class LoginInteractor implements LoginInteractorInput {

    LoginPresenterInput output;
    private static String TAG = LoginInteractor.class.getSimpleName();

    @Override
    public void fetchLogin(LoginRequest loginRequest) {

        try {
            APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<LoginResponse> call = apiInterface.login(loginRequest.user, loginRequest.password);
            LoginResponse loginResponse = call.execute().body();
            output.presentLoginMetaData(loginResponse);
        } catch (IOException e) {
            Log.e("erro " +  TAG, e.getMessage());
            //todo chamar output de erro do login
        }
    }
}
