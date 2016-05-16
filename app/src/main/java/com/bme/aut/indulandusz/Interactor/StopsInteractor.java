package com.bme.aut.indulandusz.Interactor;

import com.bme.aut.indulandusz.IndulanduszApplication;
import com.bme.aut.indulandusz.Interactor.event.GetStopsEvent;
import com.bme.aut.indulandusz.Network.DefaultApi;
import com.bme.aut.indulandusz.model.SearchResult;
import com.bme.aut.indulandusz.model.Stop;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class StopsInteractor {
    @Inject
    DefaultApi defaultApi;

    public StopsInteractor() {
        IndulanduszApplication.injector.inject(this);
    }

    public void getStops(String stopsQuery) {
        Call<List<SearchResult>> stopsQueryCall = defaultApi.searchJsonGet(new UUID(2,2), new java.math.BigDecimal(3), "apiary-1.0", "true", "BAH");
        GetStopsEvent event = new GetStopsEvent();
        try {
            Response<List<SearchResult>> response = stopsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setStops((List<Stop>) response.body().get(0).getStopIds());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

}
