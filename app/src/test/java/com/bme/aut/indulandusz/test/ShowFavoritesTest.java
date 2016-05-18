package com.bme.aut.indulandusz.test;

import com.bme.aut.indulandusz.Main.MainPresenter;
import com.bme.aut.indulandusz.Main.MainScreen;
import com.bme.aut.indulandusz.TestHelper;
import com.bme.aut.indulandusz.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = com.bme.aut.indulandusz.BuildConfig.class, sdk = 21)
public class ShowFavoritesTest {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Before
    public void setup() throws Exception {
        TestHelper.setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = MainPresenter.getInstance();
        mainPresenter.attachView(mainScreen);
    }

    @Test
    public void testShowFavorites() {
        mainPresenter.showFavorites();
        verify(mainScreen).showFavorites();
    }


    @After
    public void tearDown() {
        mainPresenter.detachView();
    }

}
