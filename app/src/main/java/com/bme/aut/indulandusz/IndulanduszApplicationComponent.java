package com.bme.aut.indulandusz;

import com.bme.aut.indulandusz.Details.DetailsPresenter;
import com.bme.aut.indulandusz.Interactor.InteractorModule;
import com.bme.aut.indulandusz.Interactor.StopsInteractor;
import com.bme.aut.indulandusz.Main.MainActivity;
import com.bme.aut.indulandusz.Network.NetworkModule;
import com.bme.aut.indulandusz.SearchResults.SearchResultsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class})
public interface IndulanduszApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(StopsInteractor stopsInteractor);

    void inject(DetailsPresenter detailsPresenter);
    void inject(SearchResultsPresenter searchResultsPresenter);
}
