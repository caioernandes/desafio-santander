package com.example.santanderdesafio.statements;

import com.example.santanderdesafio.services.APIClient;
import com.example.santanderdesafio.services.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

interface StatementsInteractorInput {
    void fetchStatementsMetaData(StatementsRequest statementsRequest);
}

public class StatementsInteractor implements StatementsInteractorInput {

    public StatementsPresenter output;
    public StatementsResponse statementsResponse;

    @Override
    public void fetchStatementsMetaData(final StatementsRequest statementsRequest) {
        statementsResponse = new StatementsResponse();

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<StatementsResponse> call = apiInterface.statements(statementsRequest.userId);
        call.enqueue(new Callback<StatementsResponse>() {
            @Override
            public void onResponse(Call<StatementsResponse> call, Response<StatementsResponse> response) {
                statementsResponse = response.body();
                output.presentStatementsMetaData(statementsResponse);
            }

            @Override
            public void onFailure(Call<StatementsResponse> call, Throwable t) {

            }
        });
    }
}
