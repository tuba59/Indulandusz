package com.bme.aut.indulandusz.Details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bme.aut.indulandusz.BuildConfig;
import com.bme.aut.indulandusz.Main.MainActivity;
import com.bme.aut.indulandusz.R;
import com.bme.aut.indulandusz.model.Stop;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    private ArrayList<Integer> departureTimes = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    @Override
    public void showDetails(String stopId) {
        if(BuildConfig.IS_MOCK){
            if(departureTimes.size() == 0) {
                departureTimes.add(4);
                departureTimes.add(10);
                departureTimes.add(16);
                departureTimes.add(22);
            }
        }
        else{
            //api hívás, hogy lekérdezzem, az adott megállóhoz tartozó járművek indulását
        }
    }

    @Override
    public void addToFavorites(Stop stop) {
        if(BuildConfig.IS_MOCK){
            MainActivity.mockFavorites.add(stop);
        }
        else{
            //db-be mentem a megállót, ha ilyen id-jű még nincs benne
            boolean isFound = false;
            List<Stop> favorites = Stop.listAll(Stop.class);
            for (Stop s:favorites) {
                if(s.getStopId().equals(stop.getStopId()))
                    isFound = true;
            }
            if(!isFound)
                stop.save();
        }
    }
}
