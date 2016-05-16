package com.bme.aut.indulandusz.Interactor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public StopsInteractor provideStopsInteractor() {
        return new StopsInteractor();
    }
}