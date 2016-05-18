package com.bme.aut.indulandusz.test;


import com.bme.aut.indulandusz.Details.DetailsPresenter;
import com.bme.aut.indulandusz.Details.DetailsScreen;
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
public class DeleteFromFavoritesTest {

    private DetailsPresenter detailsPresenter;
    private DetailsScreen detailsScreen;

    @Before
    public void setup() throws Exception {
        TestHelper.setTestInjector();
        detailsScreen = mock(DetailsScreen.class);
        detailsPresenter = DetailsPresenter.getInstance();
        detailsPresenter.attachView(detailsScreen);
    }

    @Test
    public void testDelete() {
        String stopID = "BKK_001";
        detailsPresenter.deleteFavorite(stopID);
        verify(detailsScreen).deleteFavorite(stopID);
    }


    @After
    public void tearDown() {
        detailsPresenter.detachView();
    }

}
