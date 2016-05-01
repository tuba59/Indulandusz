package com.bme.aut.indulandusz.SearchResults;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bme.aut.indulandusz.BuildConfig;
import com.bme.aut.indulandusz.Main.MainActivity;
import com.bme.aut.indulandusz.R;
import com.bme.aut.indulandusz.model.Stop;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultsScreen {

    private ArrayList<Stop> searchresults = new ArrayList<Stop>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
    }

    @Override
    public void showSearchResults(String term) {
        if(BuildConfig.IS_MOCK){
            if(searchresults.size() == 0){
                Stop s1 = new Stop("BAH-csomópont", "BKK_F01", null);
                Stop s2 = new Stop("BAH-csomópont", "BKK_F02", null);
                Stop s3 = new Stop("BAH-csomópont", "BKK_F03", null);
                searchresults.add(s1);
                searchresults.add(s2);
                searchresults.add(s3);
            }
        }
        else{
            //API hívás megállók kereséshez
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
