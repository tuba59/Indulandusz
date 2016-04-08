package com.bme.aut.indulandusz;

public class MainPresenter {

    protected MainScreen screen;

    public void attachView(MainScreen screen) {
        this.screen=screen;
    }
    public void detachView() {
        this.screen=null;
    }

}
