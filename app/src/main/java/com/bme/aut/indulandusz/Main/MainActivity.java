package com.bme.aut.indulandusz.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bme.aut.indulandusz.BuildConfig;
import com.bme.aut.indulandusz.Details.DetailsActivity;
import com.bme.aut.indulandusz.IndulanduszApplication;
import com.bme.aut.indulandusz.R;
import com.bme.aut.indulandusz.SearchResults.SearchResultsActivity;
import com.bme.aut.indulandusz.model.FavoriteAdapter;
import com.bme.aut.indulandusz.model.RecyclerItemClickListener;
import com.bme.aut.indulandusz.model.Stop;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements MainScreen {

    public static List<Stop> mockFavorites = new ArrayList<Stop>();
    private List<Stop> favorites = new ArrayList<Stop>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private EditText searchField;
    private Button searchButton;
    private Tracker mTracker;
    private final String name = "MainActivity";

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fabric.with(this, new Crashlytics());
        IndulanduszApplication application = (IndulanduszApplication) getApplication();
        mTracker = application.getDefaultTracker();
        mTracker.setScreenName(name);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mainPresenter.getInstance().attachView(this);
        showFavorites();
        searchField = (EditText) findViewById(R.id.search_edit_text);
        searchButton = (Button) findViewById(R.id.search_btn);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchField.getText().length()==0){
                    Toast.makeText(getBaseContext(), "Kérem adja meg a keresni kívánt megállót!", Toast.LENGTH_LONG).show();
                }else {
                    Intent searchIntent = new Intent(MainActivity.this, SearchResultsActivity.class);
                    searchIntent.putExtra("term", searchField.getText().toString());
                    startActivity(searchIntent);
                }

            }
        });
        logUser();

    }

    public List<Stop> getFavorites(){
        favorites = Stop.listAll(Stop.class);
        return favorites;
    }

    @Override
    public void showFavorites() {
        //ide kell egyszer a mock datás és az adatbázisból lehívós kedvenc mutatás
        if(BuildConfig.IS_MOCK){
            if(mockFavorites.size() == 0) {
                /*Stop s1 = new Stop("BAH-csomópont", "BKK_F01", null);
                Stop s2 = new Stop("Hegytető utca", "BKK_F02", null);
                mockFavorites.add(s1);
                mockFavorites.add(s2);*/
            }
        }
        else{
            //db ből lekérem a kedvenceket
            favorites = Stop.listAll(Stop.class);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.favoritesRecycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new FavoriteAdapter((BuildConfig.IS_MOCK)?mockFavorites:favorites);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent appInfo = new Intent(MainActivity.this, DetailsActivity.class);
                        appInfo.putExtra("pos", position);
                        DetailsActivity.comingFromSearchActivity = false;
                        startActivity(appInfo);
                    }
                })
        );


        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Favorites shown")
                .build());
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        showFavorites();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("", "Setting screen name: " + name);
        mTracker.setScreenName("Image~" + name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

    private void logUser() {
        // TODO: Use the current user's information
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("12345");
        Crashlytics.setUserEmail("user@fabric.io");
        Crashlytics.setUserName("Test User");
    }

}
