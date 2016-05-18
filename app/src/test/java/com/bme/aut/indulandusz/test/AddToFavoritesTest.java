package com.bme.aut.indulandusz.test;

import com.bme.aut.indulandusz.SearchResults.SearchResultsPresenter;
import com.bme.aut.indulandusz.SearchResults.SearchResultsScreen;
import com.bme.aut.indulandusz.TestHelper;
import com.bme.aut.indulandusz.model.Stop;
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
public class AddToFavoritesTest {

    private SearchResultsPresenter searchResultsPresenter;
    private SearchResultsScreen searchResultsScreen;
    private Stop newFavorite;

    @Before
    public void setup() throws Exception {
        TestHelper.setTestInjector();
        searchResultsScreen = mock(SearchResultsScreen.class);
        newFavorite = mock(Stop.class);
        searchResultsPresenter = SearchResultsPresenter.getInstance();
        searchResultsPresenter.attachView(searchResultsScreen);
    }

    @Test
    public void testAddToFavorites() {
        searchResultsPresenter.addToFavorites(newFavorite);
        verify(searchResultsScreen).addToFavorites(newFavorite);
    }


    @After
    public void tearDown() {
        searchResultsPresenter.detachView();
    }

}
