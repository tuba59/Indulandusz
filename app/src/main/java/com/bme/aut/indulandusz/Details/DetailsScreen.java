package com.bme.aut.indulandusz.Details;

import com.bme.aut.indulandusz.model.Stop;

public interface DetailsScreen {

    void showDetails(String stopId);
    void addToFavorites(Stop stop);
}
