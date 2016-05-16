package com.bme.aut.indulandusz;

import com.bme.aut.indulandusz.Interactor.InteractorModule;
import com.bme.aut.indulandusz.Network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends IndulanduszApplicationComponent {
}