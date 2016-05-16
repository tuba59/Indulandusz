package com.bme.aut.indulandusz;

import android.content.Context;

import com.bme.aut.indulandusz.Details.DetailsPresenter;
import com.bme.aut.indulandusz.Main.MainPresenter;
import com.bme.aut.indulandusz.model.Network;
import com.bme.aut.indulandusz.utils.UiExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    private Context context;

    public TestModule(Context context) {
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
    public DetailsPresenter provideDetailsPresenter() {
        return DetailsPresenter.getInstance();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}