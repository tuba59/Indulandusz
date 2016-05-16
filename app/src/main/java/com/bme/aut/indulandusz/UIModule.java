package com.bme.aut.indulandusz;

import android.content.Context;

import com.bme.aut.indulandusz.Details.DetailsPresenter;
import com.bme.aut.indulandusz.Main.MainPresenter;
import com.bme.aut.indulandusz.model.Network;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return MainPresenter.getInstance();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideArtistsPresenter() {
        return DetailsPresenter.getInstance();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }

}
