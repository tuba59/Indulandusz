package com.bme.aut.indulandusz.Details;

import com.bme.aut.indulandusz.model.Stop;

public interface DetailsScreen {

    void showDetails();
    void addToFavorites(Stop stop);
    void deleteFavorite(String stopId);
}
