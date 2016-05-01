package com.bme.aut.indulandusz.SearchResults;

import com.bme.aut.indulandusz.model.Stop;

public interface SearchResultsScreen {
    void showSearchResults(String term);
    void addToFavorites(Stop stop);
}
