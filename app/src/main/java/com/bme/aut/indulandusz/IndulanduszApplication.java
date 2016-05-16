package com.bme.aut.indulandusz;

import com.orm.SugarApp;

public class IndulanduszApplication extends SugarApp {

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