package com.bme.aut.indulandusz.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bme.aut.indulandusz.BuildConfig;
import com.bme.aut.indulandusz.R;
import com.bme.aut.indulandusz.model.Stop;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    public static ArrayList<Stop> mockFavorites = new ArrayList<Stop>();
    private List<Stop> favorites = new ArrayList<Stop>();

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter.getInstance();
        mainPresenter.attachView(this);
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
                Stop s1 = new Stop("BAH-csomópont", "BKK_F01", null);
                Stop s2 = new Stop("Hegytető utca", "BKK_F02", null);
                mockFavorites.add(s1);
                mockFavorites.add(s2);
            }
        }
        else{
            //db ből lekérem a kedvenceket
            favorites = Stop.listAll(Stop.class);
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
            //db-be mentem a megállót, ha ilyen id-jű még nincs benne
            List<Stop> favorites = Stop.listAll(Stop.class);
            for (Stop s:favorites) {
                if(s.getStopId().equals(stopId))
                    s.delete();
            }
        }
    }

}
