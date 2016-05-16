package com.bme.aut.indulandusz;

import android.app.Application;

public class IndulanduszApplication extends Application {

    public static IndulanduszApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerIndulanduszApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}