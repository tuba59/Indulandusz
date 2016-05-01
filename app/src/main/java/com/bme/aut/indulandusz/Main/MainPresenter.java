package com.bme.aut.indulandusz.Main;

public class MainPresenter {

    protected MainScreen screen;
    private static MainPresenter instance = null;

    private MainPresenter() {
    }

    public static MainPresenter getInstance() {
        if (instance == null) {
            instance = new MainPresenter();
        }
        return instance;
    }

    public void attachView(MainScreen screen) {
        this.screen=screen;
    }
    public void detachView() {
        this.screen=null;
    }

    public void showFavorites(){
        screen.showFavorites();
    }
    public void deleteFavorite(String stopId){
        screen.deleteFavorite(stopId);
    }

}
