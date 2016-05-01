package com.bme.aut.indulandusz.SearchResults;

import com.bme.aut.indulandusz.model.Stop;

public class SearchResultsPresenter {

    protected SearchResultsScreen screen;
    private static SearchResultsPresenter instance = null;

    private SearchResultsPresenter() {
    }

    public static SearchResultsPresenter getInstance() {
        if (instance == null) {
            instance = new SearchResultsPresenter();
        }
        return instance;
    }

    public void attachView(SearchResultsScreen screen) {
        this.screen=screen;
    }
    public void detachView() {
        this.screen=null;
    }


    public void showSearchResults(String term){
        screen.showSearchResults(term);
    }

    public void addToFavorites(Stop stop){
        screen.addToFavorites(stop);
    }
}
