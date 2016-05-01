package com.bme.aut.indulandusz.Details;

import com.bme.aut.indulandusz.model.Stop;

public class DetailsPresenter {

    protected DetailsScreen screen;
    private static DetailsPresenter instance = null;

    private DetailsPresenter() {
    }

    public static DetailsPresenter getInstance() {
        if (instance == null) {
            instance = new DetailsPresenter();
        }
        return instance;
    }

    public void attachView(DetailsScreen screen) {
        this.screen=screen;
    }
    public void detachView() {
        this.screen=null;
    }

    public void showFavorites(String stopId){
        screen.showDetails(stopId);
    }

    public void addToFavorites(Stop stop){
        screen.addToFavorites(stop);
    }

}
