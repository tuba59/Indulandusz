package com.bme.aut.indulandusz.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bme.aut.indulandusz.BuildConfig;
import com.bme.aut.indulandusz.Main.MainActivity;
import com.bme.aut.indulandusz.R;
import com.bme.aut.indulandusz.SearchResults.SearchResultsActivity;
import com.bme.aut.indulandusz.model.DetailsAdapter;
import com.bme.aut.indulandusz.model.Stop;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;
    private ArrayList<Integer> departureTimes = new ArrayList<Integer>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private int selectedItemPosition;
    public static boolean comingFromSearchActivity = false;
    private TextView detailedStopName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        detailsPresenter.getInstance().attachView(this);
        detailedStopName = (TextView) findViewById(R.id.nameOfDetailedStop);
        showDetails();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(comingFromSearchActivity) {
            getMenuInflater().inflate(R.menu.menu_add, menu);
        }else {
            getMenuInflater().inflate(R.menu.menu_del, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                addToFavorites(SearchResultsActivity.searchResults.get(selectedItemPosition));
                Toast.makeText(getBaseContext(), "A megálló a kedvencekhez adva!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_del:
                deleteFavorite(MainActivity.mockFavorites.get(selectedItemPosition).getStopId());
                Toast.makeText(getBaseContext(), "A megálló eltávolítva a kedvencek közül!", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void showDetails() {
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

        mRecyclerView = (RecyclerView) findViewById(R.id.detailsRecycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        Intent i = getIntent();
        if(comingFromSearchActivity) {
            selectedItemPosition = i.getIntExtra("pos2", -1);
            mAdapter = new DetailsAdapter((BuildConfig.IS_MOCK) ? SearchResultsActivity.searchResults.get(selectedItemPosition).getVehicleList() : null);
            detailedStopName.setText(SearchResultsActivity.searchResults.get(selectedItemPosition).getName());
        }else{
            selectedItemPosition = i.getIntExtra("pos", -1);
            mAdapter = new DetailsAdapter((BuildConfig.IS_MOCK) ? MainActivity.mockFavorites.get(selectedItemPosition).getVehicleList() : null);
            detailedStopName.setText(MainActivity.mockFavorites.get(selectedItemPosition).getName());
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent main = new Intent(DetailsActivity.this, MainActivity.class);
        startActivity(main);
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

    @Override
    public void deleteFavorite(String stopId) {
        if(BuildConfig.IS_MOCK){
            int index = -1;
            for(Stop s: MainActivity.mockFavorites){
                if(s.getStopId().equals(stopId)){
                    index = MainActivity.mockFavorites.indexOf(s);
                }
            }
            if(index != -1)
                MainActivity.mockFavorites.remove(index);
        }
        else{
            List<Stop> favorites = Stop.listAll(Stop.class);
            for (Stop s:favorites) {
                if(s.getStopId().equals(stopId))
                    s.delete();
            }
        }
    }
}
