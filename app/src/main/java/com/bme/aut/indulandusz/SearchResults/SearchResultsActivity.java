package com.bme.aut.indulandusz.SearchResults;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bme.aut.indulandusz.BuildConfig;
import com.bme.aut.indulandusz.Details.DetailsActivity;
import com.bme.aut.indulandusz.IndulanduszApplication;
import com.bme.aut.indulandusz.Main.MainActivity;
import com.bme.aut.indulandusz.R;
import com.bme.aut.indulandusz.model.FavoriteAdapter;
import com.bme.aut.indulandusz.model.RecyclerItemClickListener;
import com.bme.aut.indulandusz.model.Stop;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultsScreen {

    public static ArrayList<Stop> searchResults = new ArrayList<Stop>();
    public static List<Stop> mockStopList = new ArrayList<Stop>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FavoriteAdapter mAdapter;
    private Tracker mTracker;
    private final String name = "SearchResultsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        IndulanduszApplication application = (IndulanduszApplication) getApplication();
        mTracker = application.getDefaultTracker();
        mTracker.setScreenName(name);
        Intent i = getIntent();
        String term = i.getExtras().getString("term");
        showSearchResults(term);
    }

    @Override
    public void showSearchResults(String term) {
        if(BuildConfig.IS_MOCK){
            if(mockStopList.size() == 0){
                Stop s1 = new Stop("BAH-csomópont", "BKK_F01", null);
                Stop s2 = new Stop("Hegytető utca", "BKK_F02", null);
                Stop s3 = new Stop("Móricz Zsigmond körtér", "BKK_F03", null);
                Stop s4 = new Stop("Széll Kálmán tér", "BKK_F04", null);
                Stop s5 = new Stop("Ferenciek tere", "BKK_F05", null);
                Stop s6 = new Stop("Blaha Lújza tér", "BKK_F06", null);
                Stop s7 = new Stop("Boráros tér", "BKK_F07", null);
                Stop s8 = new Stop("Déli pályaudvar", "BKK_F08", null);
                Stop s9 = new Stop("Jászai Mari tér", "BKK_F09", null);
                Stop s10 = new Stop("Csörsz utca", "BKK_F10", null);
                mockStopList.add(s1);
                mockStopList.add(s2);
                mockStopList.add(s3);
                mockStopList.add(s4);
                mockStopList.add(s5);
                mockStopList.add(s6);
                mockStopList.add(s7);
                mockStopList.add(s8);
                mockStopList.add(s9);
                mockStopList.add(s10);
            }


        }
        else{
            //API hívás megállók kereséshez
        }
        searchResults.clear();
        for(Stop s : mockStopList){
            if(s.getName().toLowerCase().contains(term.toLowerCase())){
                searchResults.add(s);
            }
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.searchResultsRecycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new FavoriteAdapter((BuildConfig.IS_MOCK)?searchResults:null);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent appInfo = new Intent(SearchResultsActivity.this, DetailsActivity.class);
                        appInfo.putExtra("pos2", position);
                        DetailsActivity.comingFromSearchActivity = true;
                        startActivity(appInfo);
                    }
                })
        );

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
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("New favorite added")
                .build());
    }
}
